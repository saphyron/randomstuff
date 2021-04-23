package resturant;

public class Common {

	private int klarTilLavning = 0;
	private int lavet = 0;

	public synchronized int naesteBestilling() {
		klarTilLavning++;
		System.out.println(" tager imod kunde" + " og laver bestilling " + klarTilLavning);
		notify();
		return klarTilLavning;
	}


	public synchronized int bestillingLavet() {
		try {
			if (klarTilLavning <= lavet) {
				System.out.println(" venter paa bestilling.");
				try {
					wait();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} finally {
			lavet++;
			System.out.println(" har lavet bestilling: " + lavet);
		}
		return lavet;
	}

}
