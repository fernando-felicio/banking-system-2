package model.entities;

import model.enums.Status;
import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	private Status status;
	
	public Account() {
		super();
	}
	
	public Account(Integer number, String holder, Double balance, Double withDrawLimit, Status status) {
		
		this.balance = balance;
		
		if (this.balance < 100.0) {
			throw new DomainException("The initial balance must be greater than $100.00");
		}
		
		this.number = number;
		this.holder = holder;
		this.withDrawLimit = withDrawLimit;
		this.status = status;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public Double deposit(Double amount) {
		return this.balance += amount;
	}
	
	public Double withdraw(Double amount) {
		
		if (amount > this.balance) {
			throw new DomainException("You don't make a withdraw greater than the account balance");
		}
		if (amount > this.withDrawLimit) {
			throw new DomainException("Withdraw is greater than WithDraw limit");
		}		
		
		return this.balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Account number: "
				+number
				+", Holder: "
				+holder
				+", WithDraw Limit: "
				+withDrawLimit
				+", Balance: "
				+balance;
	}

}
