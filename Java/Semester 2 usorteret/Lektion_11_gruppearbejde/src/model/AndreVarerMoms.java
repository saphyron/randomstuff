package model;

public class AndreVarerMoms implements Moms {

	@Override
	public double salgsPris(double pris) {
		pris = pris * 1.25;
		return pris;
	}

}
