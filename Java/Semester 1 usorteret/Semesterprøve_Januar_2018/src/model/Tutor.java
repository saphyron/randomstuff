package model;

import java.util.ArrayList;

public class Tutor {
	
	private String navn;
	private String email;
	private ArrayList<Arrangement> arrangement;
	private Hold hold;
	
	public Tutor(String navn, String email) {
		this.email = email;
		this.navn = navn;
		arrangement = new ArrayList<Arrangement>();
	}
	
	public void addArrangement(Arrangement arr) {
		if(!arrangement.contains(arr)) {
			arrangement.add(arr);
		}
	}
	
	public void removeArrangement(Arrangement arr) {
		if(arrangement.contains(arr)) {
			arrangement.remove(arr);
		}
	}

	public String getNavn() {
		return navn;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Arrangement> getArrangement() {
		return new ArrayList<>(arrangement);
	}

	public Hold getHold() {
		return hold;
	}
	
	public double arrangementPris() {
		double pris = 0;
		for (Arrangement arange: arrangement) {
			pris += arange.getPris();
		}
		return pris;
	}
	
	public boolean tidsOverlap(ArrayList<Arrangement> arrangement) {
		boolean tidsOverlap = false;
		int i = 0;
		while (!tidsOverlap && i < arrangement.size()) {
			if (arrangement.get(i).getStartTid() == arrangement.get(i+1).getStartTid()) {
				tidsOverlap = true;
			} else {
				i++;
			}
		}
		return tidsOverlap;
	}
	
	

}
