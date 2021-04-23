package storage;

import java.util.ArrayList;

import model.Booking_konference;
import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Serviceydelse;
import model.Udflugt;

public class Storage {

	private static ArrayList<Serviceydelse> serviceydelser = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Udflugt> udflugter = new ArrayList<>();
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Ledsager> ledsagere = new ArrayList<>();
	private static ArrayList<Booking_konference> booking_konferencer = new ArrayList<>();
	
	
	// -------Serviceydelse---------------------------------------------

	public static ArrayList<Serviceydelse> getServiceydelse() {
		return new ArrayList<Serviceydelse>(serviceydelser);
	}

	public static void addServiceydelse(Serviceydelse serviceydelse) {
		serviceydelser.add(serviceydelse);
	}

	public static void removeCompany(Serviceydelse serviceydelse) {
		serviceydelser.remove(serviceydelse);
	}

	// -------Hotel------------------------------------------------------

	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	}

	public static void addhotel(Hotel hotel) {
		hoteller.add(hotel);
	}

	public static void removeHotel(Hotel hotel) {
		hoteller.remove(hotel);
	}

	// ------Udflugt------------------------------------------------------

	public static ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}

	public static void addUdflugt(Udflugt udflugt) {
		udflugter.add(udflugt);
	}

	public static void removeUdflugt(Udflugt udflugt) {
		udflugter.remove(udflugt);
	}

	// ------Konference---------------------------------------------------

	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<Konference>(konferencer);
	}

	public static void addKonference(Konference konference) {
		konferencer.add(konference);
	}

	public static void removeKonference(Konference konference) {
		konferencer.remove(konference);
	}
	
	// ------Deltager------------------------------------------------------

	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(deltagere);
	}

	public static void addDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}

	public static void removeDeltager(Deltager deltager) {
		deltagere.remove(deltager);
	}
	
	// -----Ledsager---------------------------------------------------------

	public static ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<Ledsager>(ledsagere);
	}

	public static void addLedsager(Ledsager ledsager) {
		ledsagere.add(ledsager);
	}

	public static void removeLedsager(Ledsager ledsager) {
		ledsagere.remove(ledsager);
	}
	
	// -----Serviceydesler-----------------------------------------------------

	public static void removeServiceydelse(Serviceydelse serviceydelse) {
		serviceydelser.remove(serviceydelse);
	}

	//------Booking----------------------------------------------------------------
	
	public static ArrayList<Booking_konference> getBooking_konferencer(){
        return new ArrayList<>(booking_konferencer);
    }

    public static void addBooking_konference(Booking_konference booking_konference){
        booking_konferencer.add(booking_konference);
    }
    
    public static void removeBooking_konference(Booking_konference booking_konference) {
        booking_konferencer.remove(booking_konference);
    }
	
}
