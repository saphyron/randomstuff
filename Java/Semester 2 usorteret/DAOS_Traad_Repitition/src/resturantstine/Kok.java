package resturantstine;

public class Kok extends Thread {

	private static int bestillingID = 1;
	private int id;
	private Common bestilling;
	private String navn;

	public Kok(Common lb, String navn) {
		id = ++bestillingID;
		bestilling = lb;
		this.navn = navn;
	}

	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1500));
				System.out.print(this.navn);
				bestilling.bestillingLavet();
			} catch (InterruptedException e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
	}
}
