package model;

public class ElArtikel extends Varer{
	
	private int kiloWattTimerGns;

	/**
	 * @param kiloWattTimerGns
	 */
	public ElArtikel(double pris, String navn, String beskrivelse, int kiloWattTimerGns, Moms moms) {
		super(pris, navn, beskrivelse, moms);
		this.kiloWattTimerGns = kiloWattTimerGns;
	}

	public int getKiloWattTimerGns() {
		return kiloWattTimerGns;
	}

	public void setKiloWattTimerGns(int kiloWattTimerGns) {
		this.kiloWattTimerGns = kiloWattTimerGns;
	}
	
	

}
