package eksempelAnsat;

public class KommissionAnsat extends Ansat{
	
	private double salg;
	private double kommissionsProcent;

	public KommissionAnsat(String fornavn, String efternavn, String cpr, double salg, double kommissionsProcent) {
		super(fornavn, efternavn, cpr);
		this.salg = salg;
		this.kommissionsProcent = kommissionsProcent;
	}	

	public double getSalg() {
		return salg;
	}

	public void setSalg(double salg) {
		this.salg = salg;
	}

	public double getKommissionsProcent() {
		return kommissionsProcent;
	}

	public void setKommissionsProcent(double kommissionsProcent) {
		this.kommissionsProcent = kommissionsProcent;
	}
	
	@Override
	public double udregnLoen() {		
		return kommissionsProcent*salg;
	}

	@Override
	public String toString() {
		return  super.toString() + "\nSalg: " + salg + "\nProcent: " + kommissionsProcent;
	}

}
