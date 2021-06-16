package in.muthukumari.model;

import lombok.ToString;

@ToString
public class Recipient {

	// Declare all the variables
	private long senderAccNum;
	private long receiverAccNum;
	private double balanceAmount;
	private double transferAmount;
	private String receiverbank;

	/**
	 * This method used to get the sender account number
	 * 
	 * @return
	 */
	public long getSenderAccNum() {
		return senderAccNum;
	}

	/**
	 * This method used to set the sender account number
	 * 
	 * @param senderAccNum
	 */
	public void setSenderAccNum(long senderAccNum) {
		this.senderAccNum = senderAccNum;
	}

	/**
	 * This method used to get the receiver account number
	 * 
	 * @return
	 */
	public long getReceiverAccNum() {
		return receiverAccNum;
	}

	/**
	 * This method used to set the receiver account number
	 * 
	 * @param receiverAccNum
	 */
	public void setReceiverAccNum(long receiverAccNum) {
		this.receiverAccNum = receiverAccNum;
	}

	/**
	 * This method used to get the sender balance amount
	 * 
	 * @return
	 */
	public double getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * This method used to set the sender balance amount
	 * 
	 * @param balanceAmount
	 */
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * This method used to get the transfer amount
	 * 
	 * @return
	 */
	public double getTransferAmount() {
		return transferAmount;
	}

	/**
	 * This method used to set the transfer amount
	 * 
	 * @param transferAmount
	 */
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	/**
	 * This method used toget the receiver bank name
	 * 
	 * @return
	 */
	public String getReceiverbank() {
		return receiverbank;
	}

	/**
	 * This method used to set the receiver bank name
	 * 
	 * @param receiverbank
	 */
	public void setReceiverbank(String receiverbank) {
		this.receiverbank = receiverbank;
	}

}
