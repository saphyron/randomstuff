package eksempelAnsat;

public class PlusKommissionAnsat extends KommissionAnsat {
	
	private double baseLoen;

	public PlusKommissionAnsat(String fornavn, String efternavn, String cpr, double salg, double kommissionsProcent,
			double baseLoen) {
		super(fornavn, efternavn, cpr, salg, kommissionsProcent);
		this.baseLoen = baseLoen;
	}

	public double getBaseLoen() {
		return baseLoen;
	}

	public void setBaseLoen(double baseLoen) {
		this.baseLoen = baseLoen;
	}

	public double udregnLoen() {
		//TODO
		return 0.0;
	}

	@Override
	public String toString() {
		//TODO
		return "";
	}
	
	

}
