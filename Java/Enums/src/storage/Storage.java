package storage;

import java.util.ArrayList;

import application.Plads;
import application.Reservation;
import application.Arrangement;

public class Storage {
	
	private static ArrayList<Plads> pladser = new ArrayList<>();
	private static ArrayList<Reservation> reservationer = new ArrayList<>();
	private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
	
	//-----------------------------------------
	
	public static ArrayList<Plads> getPladser() {
		return new ArrayList<Plads>(pladser);
	}
	
	public static void addPladser(Plads plads) {
		pladser.add(plads);		
	}
	
	public static void removePladser(Plads plads) {
		pladser.add(plads);
	}
	
	//-----------------------------------------
	
	public static ArrayList<Reservation> getReservationer() {
		return new ArrayList<Reservation>(reservationer);
	}
	
	public static void addReservationer(Reservation reservation) {
		reservationer.add(reservation);		
	}
	
	public static void removeReservationer(Reservation reservation) {
		reservationer.add(reservation);
	}
	
	//-----------------------------------------
	
	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<Arrangement>(arrangementer);
	}
	
	public static void addArrangementer(Arrangement arrangement) {
		arrangementer.add(arrangement);		
	}
	
	public static void removeArrangementer(Arrangement arrangement) {
		arrangementer.add(arrangement);
	}
	
	//-----------------------------------------

}
