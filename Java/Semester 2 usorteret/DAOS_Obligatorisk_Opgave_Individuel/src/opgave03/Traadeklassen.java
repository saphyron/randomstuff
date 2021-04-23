package opgave03;

public class Traadeklassen extends Thread{
	
	private Faelles faelles;
	private String navn;
	/**
	 * Constructor for trådeklassen
	 * @param navn, String som bruges til at navngive klassen
	 * @param faelles, Faelles, tager en faelles klasse i brug
	 */
	public Traadeklassen (String navn, Faelles faelles) {
		super();
		this.faelles = faelles;
		this.navn = navn;
	}
	//Run metode for tråden.
	public void run() {
		for (int j = 0; j < 100; j++) {
			this.faelles.kritiskSection();
			this.faelles.tagerRandomTid(100);
			System.out.println(this.navn + " " + "Taeller er: " + this.faelles.getTaeller());
		}
		System.out.println("Taeller er: " + this.faelles.getTaeller());
	}

}
