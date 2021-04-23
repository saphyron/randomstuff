package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Booking_hotel;
import model.Booking_konference;
import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Serviceydelse;
import model.Udflugt;
import storage.Storage;

public class Controller {

	//create
    public static Konference createKonference(String navn, double pris, LocalDate startdato, 
    		LocalDate slutdato, LocalDate tilmeldingsfrist) {
        Konference konference = new Konference(navn, pris, startdato, slutdato, tilmeldingsfrist);
        Storage.addKonference(konference);
        return konference;
    }
	
	//delete
    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }
	
	//update
    public static void updateKonference(Konference konference, String navn, double pris, LocalDate startdato, 
			LocalDate slutdato, LocalDate tilmeldingsfrist) {
        konference.setNavn(navn);
        konference.setPris(pris);
        konference.setStartdato(startdato);
        konference.setSlutdato(slutdato);
        konference.setTilmeldingsfrist(tilmeldingsfrist);
    }

	
	//get
    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }


	
	/**
	 * Deltager-metoder
	 * create, delete, update, get
	 */
	
	//create
	public static Deltager createDeltager(String navn, String telefon, String adresse, String by, String land, boolean foredragsholder) {
		Deltager deltager = new Deltager(navn, telefon, adresse, by, land, foredragsholder);
        Storage.addDeltager(deltager);
        return deltager;
	}
	
	
	//delete
    public static void deleteDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }
	
	
	//update
    public static void updateDeltager(Deltager deltager, String navn, String telefon, String adresse, String by, String land, boolean foredragsholder) {
        deltager.setNavn(navn);
        deltager.setTelefon(telefon);
        deltager.setAdresse(adresse);
        deltager.setBy(by);
        deltager.setLand(land);
    }
	
	//get
    public static ArrayList<Deltager> getDeltager() {
        return Storage.getDeltagere();
    }
	
	
	/**
	 * Udflugt-metoder
	 * create, delete, update, get
	 */
	
	//create
	public static Udflugt createUdflugt(String navn, double pris, LocalDate dato, boolean frokost) {
		Udflugt udflugt = new Udflugt(navn, pris, dato, frokost);
        Storage.addUdflugt(udflugt);
        return udflugt;
	}
	
	
	//delete
    public static void deleteUdflugt(Udflugt udflugt) {
        Storage.removeUdflugt(udflugt);
    }
	
	
	//update
    public static void updateUdflugt(Udflugt udflugt, String navn, double pris, LocalDate dato, boolean frokost) {
    	udflugt.setNavn(navn);
    }
	
	//get
    public static ArrayList<Udflugt> getUdflugt() {
        return Storage.getUdflugter();
    }
	
	
	/**
	 * Ledsager-metoder
	 * create, delete, update, get
	 */
	
	//create
	public static Ledsager createLedsager(String navn) {
		Ledsager ledsager = new Ledsager(navn);
        Storage.addLedsager(ledsager);
        return ledsager;
	}
	
	
	//delete
    public static void deleteLedsager(Ledsager ledsager) {
        Storage.removeLedsager(ledsager);
    }
	
	
	//update
    public static void updateLedsager(String navn, Ledsager ledsager) {
    	ledsager.setNavn(navn);
    }
	
	//get
    public static ArrayList<Ledsager> getLedsager() {
        return Storage.getLedsagere();
    }

	/**
	 * Booking_konference-metoder
	 * create, delete, update, get
	 */
	
	//create
	
	
	//delete
	
	
	//update
	
	
	//get
	

	/**
	 * Hotel-metoder
	 * create, delete, update, get
	 */
	
	//create
	public static Hotel createHotel(String navn, double dobbeltvaerelse, double enkeltvaerelse) {
		Hotel hotel = new Hotel(navn, dobbeltvaerelse, enkeltvaerelse);
        Storage.addhotel(hotel);
        return hotel;
	}
	
	public static Hotel createHotel(Serviceydelse serviceydelse, String navn, double dobbeltvaerelse, double enkeltvaerelse) {
		Hotel hotel = new Hotel(serviceydelse, navn, dobbeltvaerelse, enkeltvaerelse);
        Storage.addhotel(hotel);
        return hotel;
	}
	
	
	//delete
    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }
	
	
	//update
    public static void updateHotel(Hotel hotel, String navn, double dobbeltvaerelse, double enkeltvaerelse) {
    	hotel.setNavn(navn);
    	hotel.setDobbeltvaerelse(dobbeltvaerelse);
    	hotel.setEnkeltvaerelse(enkeltvaerelse);
    	
    }
	
	//get
    public static ArrayList<Hotel> getHotel() {
        return Storage.getHoteller();
    }
    
    public static void addServiceToHotel(Serviceydelse serviceydelse, Hotel hotel) {
        hotel.addServiceydelse(serviceydelse);
    }
    

	/**
	 * Booking_hotel-metoder
	 * create, delete, update, get
	 */
	
    public static Booking_konference createBookingKonference(LocalDate ankomstdato, LocalDate afrejsedato,    Booking_hotel booking_hotel, 
            Deltager deltager, Konference k) {
        Booking_konference booking = new Booking_konference(ankomstdato, afrejsedato, booking_hotel, deltager, k);
        Storage.addBooking_konference(booking);
        return booking;
    }
    
    public static void deleteBookingKonference(Booking_konference booking_konference) {
        Storage.removeBooking_konference(booking_konference);
    }

    public static ArrayList<Booking_konference> getBookingKonference() {
        return Storage.getBooking_konferencer();
    }
    
	/**
	 * Serviceydelser-metoder
	 * create, delete, update, get
	 */
	
	//create
	public static Serviceydelse createServiceydelse(String ydelsestype, double ydelsespris) {
		Serviceydelse serviceydelse = new Serviceydelse(ydelsestype, ydelsespris);
        Storage.addServiceydelse(serviceydelse);
        return serviceydelse;
	}
	
	
	//delete
    public static void deleteServiceydelse(Serviceydelse serviceydelse) {
        Storage.removeServiceydelse(serviceydelse);
    }
	
	
	//update
    public static void updateServiceydelse(Serviceydelse serviceydelse, String ydelsestype, double ydelsespris) {
    	serviceydelse.setYdelsesPris(ydelsespris);
    }
	
	//get
    public static ArrayList<Serviceydelse> getServiceydelse() {
        return Storage.getServiceydelse();
    }
    
    
	
	
	
	public static void initStorage() {
		
		LocalDate startdato = LocalDate.of(2019, 5, 18);
		LocalDate slutdato = LocalDate.of(2019, 5, 20);
		LocalDate tilmeldingsfrist = LocalDate.of(2019, 5, 1);
		
		//---Tilmelding-1----------------------------------------
		
		Ledsager l3 = new Ledsager("Mette");
		Booking_hotel bh1 = new Booking_hotel(null);
		Konference k1 = new Konference("CS GO", 1500, startdato, slutdato, tilmeldingsfrist);
		Deltager d1 = new Deltager("Finn Madsen", "00-00-00-00", "testvej 51", "testby", "testland", false);
		Booking_konference bk1 = new Booking_konference(startdato, slutdato, bh1, d1, k1);

		//---Tilmelding-2----------------------------------------		
		
		Deltager d2 = new Deltager("Niels Petersen", "NielsP.-Tlf", "NielsP.-Adresse", "NielsP.-By", "NielsP.-land", false);
		Hotel h2 = new Hotel("Den Hvide Svane",0,1050);
		Booking_hotel bh2 = new Booking_hotel(h2);
		Konference k2 = new Konference("Hav og Himmel", 1500, startdato, slutdato, tilmeldingsfrist);
		Booking_konference bk2 = new Booking_konference(startdato, slutdato, bh2, d2, k2);
		
		//---Tilmelding-3----------------------------------------
		
		Deltager d3 = new Deltager("Peter Sommer", "PeterS.-Tlf", "PeterS.-Adresse", "PeterS.-By", "PeterS.-land", false);
		Hotel h3 = new Hotel("Den Hvide Svane", 1250, 0);
		Serviceydelse sy1 = new Serviceydelse("Wifi",50);
		Booking_hotel bh3 = new Booking_hotel(h3);
		bh3.addServiceydelse(sy1);
		//ledsager + udflugter
		Ledsager l1 = new Ledsager("Mic Sommer");
		Udflugt u1 = new Udflugt("Egeskov", 75, startdato, false);
		Udflugt u2 = new Udflugt("Trapholt", 200, slutdato, true);
		l1.addUdflugt(u1);
		l1.addUdflugt(u2);
		//***************************
		d3.setLedsager(l1);
		Konference k3 = new Konference("DOTA", 1500, startdato, slutdato, tilmeldingsfrist);
		Booking_konference bk3 = new Booking_konference(startdato, slutdato, bh3, d3, k3);

	
		//---Tilmelding-4----------------------------------------
		
		Deltager d4 = new Deltager("Lone Jensen", "LoneJ.-Tlf", "LoneJ.-address", "LoneJ.-By","LoneJ.-land",true);
		Hotel h4 = new Hotel("Den Hvide Svane",1250,0);
		Serviceydelse sy2 = new Serviceydelse("Wifi",50);
		Booking_hotel bh4 = new Booking_hotel(h4);
		bh4.addServiceydelse(sy2);
		//ledsager + udflugter
		Ledsager l2 = new Ledsager("Jan Madsen");
		Udflugt u3 = new Udflugt("Egeskov", 75, startdato, false);
		Udflugt u4 = new Udflugt("Byrundtur", 125, slutdato, true);
		l2.addUdflugt(u3);
		l2.addUdflugt(u4);
		//***************************
		d4.setLedsager(l2);
		Konference k4 = new Konference("WOW", 1500, startdato, slutdato, tilmeldingsfrist);
		Booking_konference bk4 = new Booking_konference(startdato, slutdato, bh4, d4, k4);

		
		//---Add-konference-objects-----------------------------
		
		Storage.addKonference(k1);
		Storage.addKonference(k2);
		Storage.addKonference(k3);
		Storage.addKonference(k4);
		
		//---Add-Serviceydelse-objects--------------------------		
		
		Serviceydelse s1 = new Serviceydelse("Wifi", 125);
		Serviceydelse s2 = new Serviceydelse("Bad", 150);
		Serviceydelse s3 = new Serviceydelse("Mad", 95);
		
		Storage.addServiceydelse(s1);
		Storage.addServiceydelse(s2);
		Storage.addServiceydelse(s3);
		
		//---Add-Hotel-Objects----------------------------------
		
		Hotel hotel1 = new Hotel("Den Hvide Svane", 1250, 1000);
		Hotel hotel2 = new Hotel("Den Glade Ged", 1500, 1400);
		Hotel hotel3 = new Hotel(s1, "Radisson", 1100,750);

		Storage.addhotel(hotel1);
		Storage.addhotel(hotel2);
		Storage.addhotel(hotel3);
		
		//---Add-Ledsager-objects-----------------------------
		
//		Storage.addLedsager(l1);
		Storage.addLedsager(l2);
		Storage.addLedsager(l3);


		//---Add-Udflugt-objects-----------------------------
		
		Storage.addUdflugt(u1);
		Storage.addUdflugt(u2);
		Storage.addUdflugt(u3);
		Storage.addUdflugt(u4);
		
		//---tilknyt udflugt--------------------------------
		
		k1.addUdflugt(u1);
		k1.addUdflugt(u2);
		k1.addUdflugt(u3);
		k1.addUdflugt(u4);
		
		k2.addUdflugt(u2);
		k3.addUdflugt(u1);
		k4.addUdflugt(u1);
		
		k1.addBooking_konference(bk4);
		
		
		
	}

	

	
}
