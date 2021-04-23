package bankkonto;

public class MainApp {

	public static void main(String[] args) {
		BankAccount bk1 = new BankAccount(0);
		BankAccount bk2 = new BankAccount(0);
		BankAccount bk3 = new BankAccount(0);
		BankAccount bk4 = new BankAccount(0);
		BankAccount bk5 = new BankAccount(0);
		BankAccount bk6 = new BankAccount(0);
		BankAccount bk7 = new BankAccount(0);
		BankAccount bk8 = new BankAccount(0);
		BankAccount bk9 = new BankAccount(0);
		
		System.out.println("There has ben created: " + bk1.getId() + " bankaccounts.");
		bk1.deposit(120);
		bk1.withdraw(20);
		System.out.println("There is currently: " + bk1.getBalance() + " kr on your account.");
		
	}

}
