package eksemplerUndervisning;

public class Vare {
	
	private String navn;
	private double pris;
	private static double moms;
	
	public Vare(String navn, double pris) {
		this.navn = navn;
		this.pris = pris;
	}
	
	public double beregnMoms() {
		double moms;
		moms = Vare.moms * pris;
		return moms;
	}
	
	

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public static double getMoms() {
		return moms;
	}

	public static void setMoms(double moms) {
		Vare.moms = moms;
	}
	

}
