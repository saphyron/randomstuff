package resturant;

public class Tjener extends Thread {

	private Common bestilling;
	private String navn;

	public Tjener(Common lb, String navn) {
		bestilling = lb;
		this.navn = navn;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
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
