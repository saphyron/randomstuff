package storage;

import java.util.ArrayList;

import model.Bil;
import model.Booking;


public class Storage {
	
	private static ArrayList<Bil> biler = new ArrayList<>();
	private static ArrayList<Booking> bookinger = new ArrayList<>();
	
	//GET metode
	public static ArrayList<Bil> getBil() {
		return new ArrayList<Bil>(biler);
	}
	
	public static ArrayList<Booking> getBooking() {
		return new ArrayList<Booking>(bookinger);
	}
	
	//ADD metode
	public static void addBiler(Bil bil) {
		biler.add(bil);
	}
	
	public static void addBookinger(Booking booking) {
		bookinger.add(booking);
	}
	
	//Remove metode

}
