package resturantstine;

public class Common {

	private int klarTilLavning = 0;
	private int lavet = 0;

	public synchronized int naesteBestilling() {
		klarTilLavning++;
		System.out.println(" tager imod kunde" + " og laver bestilling " + klarTilLavning);
		notifyAll();
		return klarTilLavning;
	}

	public synchronized int bestillingLavet() {
		try {
			wait();
			lavet++;
			System.out.println(" har lavet bestilling: " + lavet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lavet;
	}

}
