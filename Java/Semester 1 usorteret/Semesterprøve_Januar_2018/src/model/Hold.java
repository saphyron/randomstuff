package model;

import java.util.ArrayList;

public class Hold {

	private String betegnelse;
	private String holdleder;
	private ArrayList<Tutor> tutor;
	private Uddanelse uddanelse;

	public Hold(String betegnelse, String holdleder, Uddanelse uddanelse) {
		this.betegnelse = betegnelse;
		this.holdleder = holdleder;
		this.uddanelse = uddanelse;
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public String getHoldleder() {
		return holdleder;
	}

	public ArrayList<Tutor> getTutor() {
		return new ArrayList<>(tutor);
	}

	public Uddanelse getUddanelse() {
		return uddanelse;
	}

	public double arrangementPris() {
		double pris = 0;
		for (Tutor alleTutor : tutor) {
			pris += alleTutor.arrangementPris();
		}
		return pris;
	}

	public boolean harTidsoverlap(Arrangement arrangement) {
		boolean tidFound = false;
		int i = 0;
		while (!tidFound && i < tutor.get(i).getArrangement().size()) {
			if (arran) {
				tidFound = true;
			} else {
				i++;
			}
			
		}
		return tidFound;
	}

}
