package model;

import java.util.ArrayList;

public class Uddanelse {
	
	private String navn;
	private ArrayList<Hold> hold;
	
	public Uddanelse(String navn, ArrayList<Hold> hold) {
		this.navn = navn;
		this.hold = hold;
	}

	public String getNavn() {
		return navn;
	}

	public ArrayList<Hold> getHold() {
		return new ArrayList<Hold>(hold);
	}
	
	public Hold createHold(String betegnelse, String holdleder, Uddanelse uddanelse) {
		Hold hold = new Hold(betegnelse, holdleder, uddanelse);
		this.hold.add(hold);
		return hold;
	}
	
//	public void addHold(Hold holD) {
//		if (!hold.contains(holD)) {
//			hold.add(holD);
//		}
//	}
	
	
	
	

}
