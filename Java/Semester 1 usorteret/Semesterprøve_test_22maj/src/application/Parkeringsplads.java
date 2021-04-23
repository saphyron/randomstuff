package application;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import application.Bil;
import application.Parkeringshus;
import application.Invalideplads;

public class Parkeringsplads {
	
	private int nummer;
	private LocalTime ankomst;
	private Bil bil;
	private Parkeringshus parkeringshus;
	private Invalideplads invalideplads;
	
	public Parkeringsplads(int nummer) {
		this.nummer = nummer;
		this.ankomst = null;
	}
	
	public Parkeringshus getParkeringshus() {
		return parkeringshus;
	}
	
	public Invalideplads getInvalideplads() {
		return invalideplads;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public LocalTime getAnkomst() {
		return ankomst;
	}

	public void setAnkomst(LocalTime ankomst) {
		this.ankomst = ankomst;
	}

	public Bil getBil() {
		return bil;
	}
	
	public Bil createBil(String regNr, LocalTime ankomst, EnumBilmærke bilmærke) {
		Bil bil = new Bil(regNr, bilmærke);
		this.ankomst = ankomst;
		this.addBil(bil);
		return bil;
	}
	
	public void addBil(Bil bil) {
//		if (!bil.contains(bil)) {
//			bil.add(bil);
//		}
	}
	
	public void removeBil(Bil bil) {
//		if (bil.contains(bil)) {
//			bil.remove(bil);
//		}
	}

	public void setInvalideplads(Invalideplads invalideplads) {
		this.invalideplads = invalideplads;
	}

	public void setParkeringshus(Parkeringshus parkeringshus) {
		if (this.parkeringshus != parkeringshus) {
			Parkeringshus oldParkeringshus = this.parkeringshus;
			if (oldParkeringshus != null) {
				oldParkeringshus.removeParkeringspladser(this);
			}
			this.parkeringshus = parkeringshus;
			if (parkeringshus != null) {
				parkeringshus.addParkeringspladser(this);
			}
		}
		
	}
	public double parkeringsPris(LocalTime slutTidspunkt) {
		double pris = 0;
		double minutesBetween = ChronoUnit.MINUTES.between(ankomst, slutTidspunkt);
		pris = minutesBetween % 10 * 6;
		return pris;
	}
	
	public void hentBil(LocalTime slutTidspunkt, Bil bil) {
		parkeringshus.setSaldo(parkeringsPris(slutTidspunkt));
		bil = null;
		slutTidspunkt = null;
	}

}
