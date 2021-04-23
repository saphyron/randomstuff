package model;

public class Foedevarer extends Varer{
	
	private int holdbarhedsPeriodeIDage;

	/**
	 * @param holdbarhedsPeriodeIDage
	 */
	public Foedevarer(double pris, String navn, String beskrivelse, int holdbarhedsPeriodeIDage, Moms moms) {
		super(pris, navn, beskrivelse, moms);
		this.holdbarhedsPeriodeIDage = holdbarhedsPeriodeIDage;
	}

	public int getHoldbarhedsPeriodeIDage() {
		return holdbarhedsPeriodeIDage;
	}

	public void setHoldbarhedsPeriodeIDage(int holdbarhedsPeriodeIDage) {
		this.holdbarhedsPeriodeIDage = holdbarhedsPeriodeIDage;
	}

}
