package opgave;
public class TimeAnsat extends Ansat{
	
	private double timeLoen;
	private double timer;

	public TimeAnsat(String fornavn, String efternavn, String cpr, double timeLoen, double timer) {
		super(fornavn, efternavn, cpr);
		this.timeLoen = timeLoen;
		this.timer = timer;
		
	}

	@Override
	public String toString() {
		return  super.toString() + "\ntimeløn: " + timeLoen + "\ntimer: " + timer;
	}

	@Override
	public double udregnLoen() {
		return timer*timeLoen;
	}

}
