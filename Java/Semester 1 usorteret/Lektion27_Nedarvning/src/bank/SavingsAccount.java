package bank;

public class SavingsAccount  extends BankAccount{
	
	private double interestRate;
	private double minBalance;
	
	public SavingsAccount() {
		interestRate = 10;
		minBalance = 100;
	}
	
	public void setInterestRate(double rate) {
		interestRate = rate;
	}
	
	public void withdraw(double amount) {
		super.withdraw(amount);
		double balance = getBalance();
		if (balance < minBalance) {
			minBalance = balance;
		}
	}

	@Override
	public void monthEnd() {
		double interest = minBalance * interestRate / 100;
		deposit(interest);
		minBalance = getBalance();
	}

}
