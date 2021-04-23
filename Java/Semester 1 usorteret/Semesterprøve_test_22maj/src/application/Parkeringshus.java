package application;

import java.time.LocalTime;
import java.util.ArrayList;

public class Parkeringshus {
	
	private String addresse;
	private final ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();
	private double saldo;
	private ArrayList<String> optagetPladser = new ArrayList<>();
	
	public Parkeringshus(String addresse) {
		this.addresse = addresse;
	}
	
	public String toString() {
		return addresse;
	}
	
	public ArrayList<Parkeringsplads> getParkeringsplads() {
		return new ArrayList<>(parkeringspladser);
	}
	
	public Parkeringsplads createParkeringsplads(int nummer) {
		Parkeringsplads parkeringsplads = new Parkeringsplads(nummer);
		this.addParkeringspladser(parkeringsplads);
		return parkeringsplads;
	}
	
	public Parkeringsplads createInvalideplads(int nummer, double areal) {
		Invalideplads invalideplads = new Invalideplads(nummer, areal);
		this.addParkeringspladser(invalideplads);
		return invalideplads;
	}
	
	public void addParkeringspladser(Parkeringsplads parkeringsplads) {
		if (!parkeringspladser.contains(parkeringsplads)) {
			parkeringspladser.add(parkeringsplads);
			parkeringsplads.setParkeringshus(this);
		}
	}
	
	public void removeParkeringspladser(Parkeringsplads parkeringsplads) {
		if (parkeringspladser.contains(parkeringsplads)) {
			parkeringspladser.remove(parkeringsplads);
			parkeringsplads.setParkeringshus(null);
		}
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	
	public int antalLedigePladser() {
		int antalPladser = 0;
		
		return antalPladser;
	}
	
	public int findPladsMedBil(String regNummer) {
		boolean found = false;
        int i = 0;
        while (!found && i < parkeringspladser.size()) {
        	if (parkeringspladser.get(i).getBil() != null && parkeringspladser.get(i).getBil().getRegNr().equals(regNummer)) {
        		found = true;
        	} else {
        		i++;
        	}
        }
        if (found) {
        	return parkeringspladser.get(i).getNummer();
        } else {
        	return -1;
        }
	}
	
	public double getPrisForParkering(ArrayList<Parkeringsplads> parkering, LocalTime slutTidspunkt) {
		double pris = 0;
		for (Parkeringsplads park : parkering) {
			pris = park.parkeringsPris(slutTidspunkt);
		}
		return pris;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo += saldo;
	}
	
	public int findAntalBiler(EnumBilmærke bilmærke) {
		int antal = 0;
		for (int i = 0; i < getParkeringsplads().size(); i++) {
			if (getParkeringsplads().get(i).equals(bilmærke)) {
				antal++;
			}
		}
		return antal;
	}

//	 Kunne jeg ikke huske hvordan man gjorde
	public ArrayList<String> optagetPladser() {
		ArrayList<String> toReturn = new ArrayList<>();
//		for (Parkeringsplads plads : parkeringspladser)	
		
		return toReturn;
	}

}
