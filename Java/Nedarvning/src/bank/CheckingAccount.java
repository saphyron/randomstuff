package bank;

public class CheckingAccount extends BankAccount{
	
	private int withdrawals;
	
	public CheckingAccount() {
		withdrawals = 0;
	}
	
	public void withdraw(double amount) {
		final int FREE_WITHDRAWALS = 3;
		final int WITHDRAWAL_FEE = 1;
		
		super.withdraw(amount);
		withdrawals++;
		if (withdrawals > FREE_WITHDRAWALS) {
			super.withdraw(WITHDRAWAL_FEE);
		}
	}

	@Override
	public void monthEnd() {
		withdrawals = 0;
		
	}

}
