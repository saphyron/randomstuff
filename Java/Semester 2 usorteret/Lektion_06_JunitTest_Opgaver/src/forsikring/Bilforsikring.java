package forsikring;

public class Bilforsikring {
	private double grundpr�mie;
	
	public double getGrundpr�mie() {
		return grundpr�mie;
	}
	
	public  void setGrundpr�mie(double grundPr) {
		if (grundPr <= 0) throw new RuntimeException("grundPr skal vaere positiv");
		grundpr�mie = grundPr;
	}

	public double beregnpr�mie(int alder, boolean isKvinde, int skadeFrie�r) {
		double pr�mie = grundpr�mie;
		if (pr�mie == 0) {
			throw new RuntimeException("GrundPræmie har ikke fået en værdi");
		}
		if (alder < 18) {
			throw new RuntimeException("Du er for ung til at tegne en forsikring");
		}
		if (alder-skadeFrie�r < 18) {
			throw new RuntimeException("Du kan ikke have kaert skadefri sålænge");
		}
		if (skadeFrie�r < 0) {
			throw new RuntimeException("Antal skade frie år skal være positiv");
		}
		
		if (alder <25) pr�mie = 1.25 * grundpr�mie;
		
		if (isKvinde) pr�mie = pr�mie *0.95;
		
		if (skadeFrie�r < 3);
		else if (skadeFrie�r < 6) {
			pr�mie = pr�mie *0.85;
		}
		else if (skadeFrie�r < 9) {
			pr�mie = pr�mie * 0.75;
		}
		else {
			pr�mie = pr�mie * 0.65;
		}
		return pr�mie;
	}

}
