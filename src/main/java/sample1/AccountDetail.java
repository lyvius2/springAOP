package sample1;

import java.util.Date;

public class AccountDetail {

	private String owner;
	private int balanceAmount;
	private Date lastTransactionTime;
	
	public AccountDetail(){}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getLastTransactionTime() {
		return lastTransactionTime;
	}

	public void setLastTransactionTime(Date lastTransactionTime) {
		this.lastTransactionTime = lastTransactionTime;
	}
}
