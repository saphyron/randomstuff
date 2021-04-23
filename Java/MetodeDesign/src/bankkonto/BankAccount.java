package bankkonto;

public class BankAccount {
	/**
	 * attributes
	 */
	private double balance;
	private static int id = 0;

	/**
	 * Constructor.
	 * @param initialBalance, positive amount.
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
		id++;
	}
	/**
	 * Method to deposit a, amount.
	 * @param amount, positive amount.
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	/**
	 * Method to withdraw an amount.
	 * @param amount, negative amount.
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}
	/**
	 * Method to get balance.
	 * @return balance.
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * Method to get amount of accounts created.
	 * @return id.
	 */
	public static int getId() {
		return id;
	}

}
