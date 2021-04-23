package resturantstine;

public class Tjener extends Thread {

	private Common bestilling;
	private String navn;

	public Tjener(Common lb, String navn) {
		bestilling = lb;
		this.navn = navn;
	}

	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				System.out.print(this.navn);
				bestilling.naesteBestilling();
			} catch (InterruptedException e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
	}
}
