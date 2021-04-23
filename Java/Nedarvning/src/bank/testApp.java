package bank;

import java.util.ArrayList;

public class testApp {

	public static void main(String[] args) {
		
		BankAccount s2 = new SavingsAccount();
		SavingsAccount s1 = new SavingsAccount();
		CheckingAccount c1 = new CheckingAccount();
		
		ArrayList<BankAccount> bankaccounts = new ArrayList<>();
		bankaccounts.add(s2);
		bankaccounts.add(s1);
		bankaccounts.add(c1);
		
		s2.deposit(100);
		c1.deposit(100);
		s1.deposit(100);
		
		for (BankAccount a : bankaccounts) {
			a.withdraw2(-20);
			System.out.println(a.getBalance());
		}
		
		System.out.println("---------");
		
		for (BankAccount a : bankaccounts) {
			a.withdraw(20);
			System.out.println(a.getBalance());
		}
		
		System.out.println("---------");
		
		for (BankAccount a : bankaccounts) {
			a.withdraw(20);
			System.out.println(a.getBalance());
		}
		
		System.out.println("---------");
		
		for (BankAccount a : bankaccounts) {
			a.withdraw(20);
			System.out.println(a.getBalance());
		}
		
		System.out.println("---------");
		
		for (BankAccount a : bankaccounts) {
			a.monthEnd();
			System.out.println(a.getBalance());
			a.deposit(100);
		}
		
		System.out.println("---------");
		
		for (BankAccount a : bankaccounts) {
			a.withdraw(20);
			System.out.println(a.getBalance());
		}
		
		System.out.println("---------");
		
	}

}
