package bank;

public abstract class BankAccount {
	
	private double balance;
	
	public BankAccount() {
		balance = 0;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void withdraw2(double amount) {
		if (amount < 0) {
			String errorMsg = "Du maa ikke haeve et negativt beloeb!";
			throw new IllegalArgumentException(errorMsg);
		} else {
			balance -= amount;
		}
	}
	
	public abstract void monthEnd();
	
	

}
