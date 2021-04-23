package eksempel1;

public class GaetEtTal extends Thread {

	private int tal;

	public GaetEtTal(int tal) {
		super();
		this.tal = tal;
	}

	public void run() {
		int taeller = 0;
		int gaet = 0;
		
		while(gaet != tal) {
			gaet = (int) (Math.random() * 100 + 1);
			System.out.println(this.getName() + " gæt " + gaet);
			taeller++;
		}
		System.out.println("Korrekt " + this.getName() + " i " + taeller + " gæt");
	}
}
