package controller;

import java.util.ArrayList;
import application.Invalideplads;
import application.Parkeringshus;
import application.Parkeringsplads;
import application.Bil;
import application.EnumBilmærke;
import storage.Storage;

public class Controller {

	// Create metoder
	public static Parkeringsplads createParkeringsplads(int nummer) {
		Parkeringsplads parkeringsplads = new Parkeringsplads(nummer);
		return parkeringsplads;
	}

	public static Invalideplads createInvalideplads(int nummer, double areal) {
		Invalideplads invalideplads = new Invalideplads(nummer, areal);
		return invalideplads;
	}

	public static Parkeringshus createParkeringshus(String addresse) {
		Parkeringshus parkeringshus = new Parkeringshus(addresse);
		Storage.addParkeringshuse(parkeringshus);
		return parkeringshus;
	}

	public static Bil createBil(String regNr, EnumBilmærke bilmærke) {
		Bil bil = new Bil(regNr, null);
		Storage.addBiler(bil);
		return bil;
	}

	// Delete Metoder
	public static void deleteParkeringsplads(Parkeringsplads parkeringsplads) {
		parkeringsplads.getParkeringshus().removeParkeringspladser(parkeringsplads);
	}

	public static void deleteInvalideplads(Invalideplads invalideplads) {
		invalideplads.getParkeringshus().removeParkeringspladser(invalideplads);
	}

//	public static void deleteParkeringshus(Parkeringshus parkeringshus) {
//		
//	}

//	public static void deleteBil(Parkeringshus parkeringshus) {
//
//	}
	
	// Update Metoder
	public static void updateParkeringsplads(Parkeringsplads parkeringsplads, int nummer) {
		parkeringsplads.setNummer(nummer);
	}
	
	public static void updateInvalideplads(Invalideplads invalideplads, int nummer, double areal) {
		invalideplads.setAreal(areal);
		invalideplads.setNummer(nummer);
	}
	
	public static void updateParkeringshus(Parkeringshus parkeringshus, String addresse) {
		parkeringshus.setAddresse(addresse);
	}
	
	public static void updateBil(Bil bil, String regNr) {
		bil.setRegNr(regNr);
	}
	
	// Get Metoder
	public static ArrayList<Parkeringshus> getParkeringshus() {
		return Storage.getParkeringshuse();
	}
	
	public static ArrayList<Bil> getBil() {
		return Storage.getBiler();
	}

	public static void initStorage() {
		
		// Added Biler
		Bil b1 = Controller.createBil("AB 11 222", EnumBilmærke.HONDA);
		Bil b2 = Controller.createBil("EF 33 444", EnumBilmærke.HONDA);
		Bil b3 = Controller.createBil("BD 55 666", EnumBilmærke.AUDI);
		// Added Parkeringshus
		Parkeringshus p1 = Controller.createParkeringshus("Havnegade 12, 8000 Aarhus");
		// Added Parkeringsplads
		for (int i = 1; i <= 100; i++) {
			Parkeringsplads pp = new Parkeringsplads(i);
			p1.addParkeringspladser(pp);
		}
		// Added Invalideplads
		for (int i = 101; i <= 110; i++) {
			Invalideplads ip = new Invalideplads(i, 18);
			p1.addParkeringspladser(ip);
		}
		// Tilføj Biler til parkeringshus
		p1.createParkeringsplads(3).addBil(b1);
		p1.createParkeringsplads(78).addBil(b2);
		p1.createParkeringsplads(105).addBil(b3);
		
		

	}

}
