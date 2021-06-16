package in.muthukumari.service;

import in.muthukumari.dao.ExistCustomerDAO;
import in.muthukumari.dao.RecipientDAO;
import in.muthukumari.exception.DBException;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.exception.ValidatorException;
import in.muthukumari.model.Recipient;
import in.muthukumari.validator.CustomerRepeatedValidator;

public class RecipientService {

	private RecipientService() {
		// Default Constructor
	}

	/**
	 * This method used to add the recipient details
	 * 
	 * @param recipient
	 * @return
	 * @throws ServiceException
	 */
	public static boolean addRecipientDetail(Recipient recipient) throws ServiceException {
		boolean isAddedToDb = false;
		double balanceAmount = getBalanceAmountAfterTransfer(recipient);
		try {
			CustomerRepeatedValidator.isSameAccountNumber(recipient);
			boolean isUpdated = ExistCustomerDAO.updateBalanceAmount(recipient.getSenderAccNum(), balanceAmount);
			if (isUpdated) {
				boolean isExists = RecipientDAO.isRepeatedAccountNumber(recipient.getReceiverAccNum());
				if (isExists) {
					double amount = getRecipientBalanceAmount(recipient);
					boolean isUpdate = ExistCustomerDAO.updateRecipientBalanceAmount(recipient.getReceiverAccNum(),
							amount);
					if (isUpdate) {
						isAddedToDb = true;
					}
				} else {
					RecipientDAO.addRecipientDetail(recipient);
					isAddedToDb = true;
				}
			}
		} catch (DBException | ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		return isAddedToDb;
	}

	/**
	 * This mthod used to get the recipient balance amount
	 * 
	 * @param recipient
	 * @return
	 * @throws DBException
	 */
	public static double getRecipientBalanceAmount(Recipient recipient) throws DBException {
		double amount = RecipientDAO.getBalanceAmount(recipient.getReceiverAccNum());
		return (amount + recipient.getTransferAmount());
	}

	/**
	 * This method used to gt the balance amount after money transfer
	 * 
	 * @param recipient
	 * @return
	 */
	public static double getBalanceAmountAfterTransfer(Recipient recipient) {

		return (recipient.getBalanceAmount() - recipient.getTransferAmount());

	}

}
