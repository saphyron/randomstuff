package model;

public class Varer {
	private double pris;
	private String navn;
	private String beskrivelse;
	private Moms moms;
	
	public Varer(double pris, String navn, String beskrivelse, Moms moms) {
		this.pris = pris;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.moms = moms;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	public double beregnMoms() {
		pris = moms.salgsPris(pris);
		return pris;
	}
	

}
