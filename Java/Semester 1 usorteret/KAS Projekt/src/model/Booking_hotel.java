package model;

import java.util.ArrayList;

public class Booking_hotel {
	
	//association -->1 Hotel (forced association)
	private Hotel hotel;
	//association -->0..* Serviceydelser
	private ArrayList<Serviceydelse> serviceydelser = new ArrayList<>();
	
	public Booking_hotel(Hotel hotel) {
		//association -->1 Hotel (forced association)
		this.hotel = hotel;
	}
	
	
	
	
	//association -->0..* Serviceydelser 
	public ArrayList<Serviceydelse> getServiceydelser(){
		return new ArrayList<>(serviceydelser);
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
	
	//association -->1 Konference (dobbelt-rettet)

	public Hotel getHotel(){
		return hotel;
	}
	
		//this method updates ArrayList "booking_konferencer" in Konference
	public void setHotel(Hotel hotel) {
		if(this.hotel != hotel) {
			Hotel oldHotel = this.hotel;
			if(oldHotel != null) {
				oldHotel.removeBooking_hotel(this);
			}
			this.hotel = hotel;
			if(hotel != null) {
				hotel.addBooking_hotel(this);
			}
		}
	}
	
	
	
	

}
