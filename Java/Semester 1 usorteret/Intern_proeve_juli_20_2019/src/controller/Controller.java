package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import model.Anbefaling;
import model.Bil;
import model.Booking;
import model.Lift;
import model.Stjerner;
import storage.Storage;

public class Controller {

	// create
	public static Bil createBil(String regNr, String chauffoer) {
		Bil bil = new Bil(regNr, chauffoer);
		Storage.addBiler(bil);
		return bil;

	}

	public static Lift createLift(LocalDateTime tidspunkt, int pris, String fraAdresse, String tilAdresse,
			int maxAntalPassager, Bil bil) {
		Lift lift = new Lift(tidspunkt, pris, fraAdresse, tilAdresse, maxAntalPassager, bil);
		return lift;
	}
	
	public static Booking createBooking(String passager, String opsamlingssted, LocalTime opsamlingstid, Lift lift) {
		try {
		if (lift.Ledigplads()) {
			Booking booking = new Booking(passager, opsamlingssted, opsamlingstid, lift);
			Storage.addBookinger(booking);
			return booking;
		
		}
		} catch (RuntimeException e) {
			System.out.println("Ingen ledige pladser");
		}
		return null;
		
	}
	
	
	public static Anbefaling createAnbefaling(Stjerner stjerner, String kommentar) {
		Anbefaling anbefaling = new Anbefaling(stjerner, kommentar);
		return anbefaling;
	}
	
	//Opgave 7
	public static Lift liftPaaDato(LocalDate dato) {
		
		return null;
	}
	
	//Opgave 8
	public static int anbefalingsFrekvens(ArrayList<Anbefaling> anbefalinger, Stjerner stjerner) {
		int antalStjerner = 0;
//		for (int i = 0; i < anbefalinger.size(); i++) {
//			if (i = 0) {
//				System.out.println(stjerner.EN);
//			}
//		}
		
		return antalStjerner;
	}
	
	//Opgave 9
	public static String findChauffoerOgAnbefaling(ArrayList<Booking> booking, String passager, String opsamlingssted, LocalTime opsamlingstid) {
		boolean found = false;
        int i = 0;
        while (!found && i < booking.size()) {
        	if (booking.get(i).equals(passager) && booking.get(i).equals(opsamlingstid) && booking.get(i).equals(opsamlingssted)) {
        		found = true;
        	} else {
        		i++;
        	}
        }
        if (found) {
        	return booking.get(i).getAf().toString();
        } else {
        	return null;
        }
	}

	// delete

	// update

	// get
	
	

	public static void initStorage() {
		
		//Creater biler
		Bil b1 = Controller.createBil("AB 12 345", "Jane Jensen");
		Bil b2 = Controller.createBil("XY 98 765", "Lene Hansen");
		
		//Adder Lift
		LocalDateTime dt1 = LocalDateTime.of(2019, 6, 22, 10, 00);
		LocalDateTime dt2 = LocalDateTime.of(2019, 6, 24, 20, 00);
		LocalDateTime dt3 = LocalDateTime.of(2019, 6, 28, 10, 00);
		Lift l1 = Controller.createLift(dt1, 90, "Aarhus", "Odense", 3, b1);
		Lift l2 = Controller.createLift(dt2, 80, "Odense", "Aarhus", 2, b1);
		Lift l3 = Controller.createLift(dt3, 85, "Aarhus", "Odense", 1, b1);
		LocalDateTime dt4 = LocalDateTime.of(2019, 6, 24, 20, 30);
		Lift l4 = Controller.createLift(dt4, 100, "Aarhus", "Odense", 3, b2);
		
		//Adder Booking
		LocalTime lt1 = LocalTime.of(10, 00);
		LocalTime lt2 = LocalTime.of(20, 15);
		LocalTime lt3 = LocalTime.of(10, 10);
		Booking bo1 = Controller.createBooking("Mette", "Aros", lt1, l1);
		Booking bo2 = Controller.createBooking("Karina", "Banegaarden", lt2, l2);
		Booking bo3 = Controller.createBooking("Camilla", "Musikhuset", lt3, l3);

	}

}
