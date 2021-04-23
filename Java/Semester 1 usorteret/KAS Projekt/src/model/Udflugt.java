package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {

	@Override
	public String toString() {
		return navn + " (" + pris + ")";
	}

	private String navn;
	private double pris;
	private LocalDate dato;
	private boolean frokost;
	//association -->0..* Ledsager (many-to-many)
	private final ArrayList<Ledsager> ledsagere;

	
	public Udflugt(String navn, double pris, LocalDate dato, boolean frokost) {
		this.navn = navn;
		this.pris = pris;
		this.dato = dato;
		this.frokost = frokost;
		ledsagere = new ArrayList<>();
	}
	
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	
	//get-metoder
	
	public String getNavn() {
		return navn;
	}

	public double getPris() {
		return pris;
	}

	public LocalDate getDato() {
		return dato;
	}

	public boolean isFrokost() {
		return frokost;
	}

	
	//Association --> 0..* Ledsager (dobbel-rettet: many-to-many)
	public ArrayList<Ledsager> getLedsager(){
		return new ArrayList<>(ledsagere);
	}
	
	public void addLedsager(Ledsager ledsager) {
		if(!ledsagere.contains(ledsager)) {
			ledsagere.add(ledsager);
			ledsager.addUdflugt(this);
		}
	}
	
	public void removeLedsager(Ledsager ledsager) {
		if(ledsagere.contains(ledsager)) {
			ledsagere.remove(ledsager);
		}
	}

	
}
