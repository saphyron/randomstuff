package model;

public class ElArtiklerMoms implements Moms {

	@Override
	public double salgsPris(double pris) {
		if (pris * 0.3 > 3) {
			pris = pris * 1.3;
			return pris;
		}
		pris =+ 3;
		return pris;
	}

}
