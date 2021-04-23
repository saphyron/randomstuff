package model;

public class FoedevarerMoms implements Moms{

	@Override
	public double salgsPris(double pris) {
		if (pris * 0.3 > 3) {
			pris = pris * 1.05;
			return pris;
		}
		pris =+ 3;
		return pris;
	}

}
