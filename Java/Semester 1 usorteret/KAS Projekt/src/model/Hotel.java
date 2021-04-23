package model;

import java.util.ArrayList;

public class Hotel {
	
	private String navn;
	private double dobbeltvaerelse;
	private double enkeltvaerelse;
	//association -->0..* Konference (dobbelt-rettet: many-to-many)
	private final ArrayList<Konference> konferencer = new ArrayList<>();
	//association -->0..* Booking_hotel (one-to-many)
	private final ArrayList<Booking_hotel> booking_hoteller = new ArrayList<>();
	//Aggregering <>-- 0..* Serviceydelse
	private final ArrayList<Serviceydelse> serviceydelser = new ArrayList<>();
	private Serviceydelse serviceydelse;
		
	public Hotel(String navn, double dobbeltvaerelse, double enkeltvaerelse) {
		this.navn = navn;
		this.dobbeltvaerelse = dobbeltvaerelse;
		this.enkeltvaerelse = enkeltvaerelse;
	}
	
	
	
	//get-metoder
	
	public Hotel(Serviceydelse serviceydelse, String navn, double dobbeltvaerelse, double enkeltvaerelse) {
		this.navn = navn;
		this.dobbeltvaerelse = dobbeltvaerelse;
		this.enkeltvaerelse = enkeltvaerelse;
		addServiceydelse(serviceydelse);
		
	}


	@Override
	public String toString() {
		return "Hotel navn: " + navn;
	}



	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getDobbeltvaerelse() {
		return dobbeltvaerelse;
	}
	
	public void setDobbeltvaerelse(double dobbeltvaerelse) {
		this.dobbeltvaerelse = dobbeltvaerelse;
	}

	public double getEnkeltvaerelse() {
		return enkeltvaerelse;
	}	
	
	public void setEnkeltvaerelse(double enkeltvaerelse) {
		this.enkeltvaerelse = enkeltvaerelse;
	}
	
	//association -->0..* Konference (dobbelt-rettet: many-to-many)
	public ArrayList<Konference> getKonferencer(){
		return new ArrayList<>(konferencer);
	}
	
	public void addKonference(Konference konference) {
		if(!konferencer.contains(konference)) {
			konferencer.add(konference);
			konference.addHotel(this);
		}
	}
	
	public void removeKonferencer(Konference konference) {
		if(konferencer.contains(konference)) {
			konferencer.remove(konference);
		}
	}
	
	
	//association -->0..* Booking_hotel (dobbelt-rettet: many-to-one)
	
	public ArrayList<Booking_hotel> getBooking_hoteller(){
		return new ArrayList<>(booking_hoteller);
	}
	
	public void addBooking_hotel(Booking_hotel booking_hotel) {
		if(!booking_hoteller.contains(booking_hotel)) {
			booking_hoteller.add(booking_hotel);
			booking_hotel.setHotel(this);
		}
	}
	
	public void removeBooking_hotel(Booking_hotel booking_hotel) {
		if(booking_hoteller.contains(booking_hotel)) {
			booking_hoteller.remove(booking_hotel);
			booking_hotel.setHotel(this);
		}
	}
	
	
	//Aggregering <>-- 0..* Serviceydelse
	
	public ArrayList<Serviceydelse> getServiceydelse(){
		return new ArrayList<>(serviceydelser);
	}
	
	public Serviceydelse createServiceydelse(String ydelsestype, double ydelsespris) {
		Serviceydelse serviceydelse = new Serviceydelse(ydelsestype, ydelsespris);
		serviceydelser.add(serviceydelse);
		return serviceydelse;
	}
	
	
	public void addServiceydelse(Serviceydelse serviceydelse) {
		if(!serviceydelser.contains(serviceydelse)) {
			serviceydelser.add(serviceydelse);
		}
	}
	
	public void removeServiceydelse(Serviceydelse serviceydelse) {
		if(serviceydelser.contains(serviceydelse)) {
			serviceydelser.remove(serviceydelse);
		}
	}

	
}
