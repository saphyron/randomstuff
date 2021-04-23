package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bil {

	private String regNr;
	private String chauffoer;
	private ArrayList<Lift> ls = new ArrayList<>();

	public Bil(String regNr, String chauffoer) {
		this.chauffoer = chauffoer;
		this.regNr = regNr;
	}
	
	

	@Override
	public String toString() {
		return this.chauffoer;
	}



	public Lift createLift(LocalDateTime tidspunkt, int pris, String fraAdresse, String tilAdresse,
			int maxAntalPassager, Bil bil) {
		Lift newLift = new Lift(tidspunkt, pris, fraAdresse, tilAdresse, maxAntalPassager, bil);
		ls.add(newLift);
		return newLift;
	}

	public void removeLift(Lift newLift) {
		if (ls.contains(newLift)) {
			ls.remove(newLift);
			newLift.removeBil();
		}
	}

	public String getRegNr() {
		return regNr;
	}

	public String getChauffoer() {
		return chauffoer;
	}

	public ArrayList<Lift> getLs() {
		return ls;
	}

	// - - - - - - - - - - - - - - - - - - - - - -
	// Opgave 3

	public int indtægt() {
		int pris = 0;
		for (int i = 0; i < ls.size(); i++) {
			pris = pris + ls.get(i).getPris();
		}
		return pris;
	}

	// - - - - - - - - - - - - - - - - - - - - - -

}
