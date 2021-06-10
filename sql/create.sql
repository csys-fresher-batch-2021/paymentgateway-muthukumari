create database bankapp_dp;

---Customer Bank Details---
create table customerbankdetails(customername varchar(50),
					 bankname varchar(20) not null,
					 branchname varchar(20) not null, 
					 ifsccode varchar(20) not null, 
					 account_no bigint primary key, 
					 balanceamount double precision, 
					 atm_no bigint unique, 
					 atmpin_no int unique, 
					 mobile_no bigint not null);

---Bank Name List---
create table banknamelist(bankname varchar(20) primary key);	

---Branch and Ifsc Code List---
create table branchandifsclist(brachname varchar(30), ifsccode varchar(20),
bankname varchar(20) foreign key(bankname) references banknamelist(bankname));

---Customer Registration Details---
create table customerdetails(mobile_no bigint,first_name varchar(20),
last_name varchar(20), email varchar(50) unique,
username varchar(10) primary key, password varchar(10));