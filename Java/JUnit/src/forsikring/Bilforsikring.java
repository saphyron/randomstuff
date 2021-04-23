package forsikring;

public class Bilforsikring {
	private double grundpraemie;
	
	public double getGrundpraemie() {
		return grundpraemie;
	}
	
	public  void setGrundpraemie(double grundPr) {
		if (grundPr <= 0) throw new RuntimeException("grundPr skal vaere positiv");
		grundpraemie = grundPr;
	}

	public double beregnpraemie(int alder, boolean isKvinde, int skadeFrieaar) {
		double praemie = grundpraemie;
		if (praemie == 0) {
			throw new RuntimeException("GrundPræmie har ikke fået en værdi");
		}
		if (alder < 18) {
			throw new RuntimeException("Du er for ung til at tegne en forsikring");
		}
		if (alder-skadeFrieaar < 18) {
			throw new RuntimeException("Du kan ikke have kaert skadefri sålænge");
		}
		if (skadeFrieaar < 0) {
			throw new RuntimeException("Antal skade frie år skal være positiv");
		}
		
		if (alder <25) praemie = 1.25 * grundpraemie;
		
		if (isKvinde) praemie = praemie *0.95;
		
		if (skadeFrieaar < 3);
		else if (skadeFrieaar < 6) {
			praemie = praemie *0.85;
		}
		else if (skadeFrieaar < 9) {
			praemie = praemie * 0.75;
		}
		else {
			praemie = praemie * 0.65;
		}
		return praemie;
	}

}
