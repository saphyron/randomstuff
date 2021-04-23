package opgave01;

public class Hund {
	
	private String navn;
	private Race race;
	private boolean stamtavle;
	private int pris;
	
	public Hund(String navn, Race race, boolean stamtavle, int pris) {
		this.navn = navn;
		this.pris = pris;
		this.race = race;
		this.stamtavle = stamtavle;
	}

	public String getNavn() {
		return navn;
	}

	public Race getRace() {
		return race;
	}

	public boolean isStamtavle() {
		return stamtavle;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

}
