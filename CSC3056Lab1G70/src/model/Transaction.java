package model;

import java.util.Date;

public class Transaction {
	String acount_number;
	public String getAcount_number() {
		return acount_number;
	}
	public void setAcount_number(String acount_number) {
		this.acount_number = acount_number;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	double transaction_amount;
	Date transaction_date;
	public Transaction(String acount_number, double transaction_amount, Date transaction_date) {
		super();
		this.acount_number = acount_number;
		this.transaction_amount = transaction_amount;
		this.transaction_date = transaction_date;
	}

}
