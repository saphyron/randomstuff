package opgave;

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
		double loen = 0;
		loen = baseLoen + super.udregnLoen();
		return loen;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + baseLoen;
	}
	
	

}
