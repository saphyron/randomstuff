package opgave02;

public class Traadeklassen extends Thread {

	private Faelles faelles;
	private String navn;
	private int thisId;
	private int concurrentId;
	/**
	 * Constructor for trådeklassen
	 * @param navn, String som bruges til at navngive klassen
	 * @param faelles, Faelles, tager en faelles klasse i brug
	 * @param thisId, int der bruges for at adskille tråene i petersens algoritme
	 */
	public Traadeklassen(String navn, Faelles faelles, int thisId) {
		super();
		this.faelles = faelles;
		this.navn = navn;
		this.thisId = thisId;
	}
	//Run metode for tråden.
	public void run() {
		concurrentId = (thisId + 1) % 2;
		for (int j = 0; j < 100; j++) {
			faelles.setFlag(true, thisId);
			faelles.setTurn(concurrentId);
			while (faelles.getFlag(concurrentId) 
					&& faelles.getTurn() == concurrentId);
			this.faelles.kritiskSection();
			faelles.setFlag(false, thisId);
			this.faelles.tagerRandomTid(100);
			System.out.println(this.navn + " " + "Taeller er: " + this.faelles.getTaeller());
		}
		System.out.println("Taeller er: " + this.faelles.getTaeller());
	}
}
