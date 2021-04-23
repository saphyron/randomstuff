package model;

public class SpritusOver90Moms implements Moms {

	@Override
	public double salgsPris(double pris) {
		pris = pris * 2.2;
		return pris;
	}

}
