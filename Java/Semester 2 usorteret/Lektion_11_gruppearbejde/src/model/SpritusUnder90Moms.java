package model;

public class SpritusUnder90Moms implements Moms {

	@Override
	public double salgsPris(double pris) {
		pris = pris * 1.8;
		return pris;
	}

}
