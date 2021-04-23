package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Booking_konference {

	private LocalDate ankomstdato;
	private LocalDate afrejsedato;
	private String firmanavn;
	private String firmaTlf;
	//association -->0..1 Booking_hotel
	private Booking_hotel booking_hotel;
	//association -->1 Deltager (tvungen association)
	private Deltager deltager;
	//association --> Konference (dobbelt-rettet)
	private Konference konference;
		
	
	//tilføjede flere parametre til konstruktoren
	public Booking_konference(LocalDate ankomstdato, LocalDate afrejsedato, String firmanavn, String firmaTlf,
			Booking_hotel booking_hotel, Deltager deltager, Konference k) {
		this.ankomstdato = ankomstdato;
		this.afrejsedato = afrejsedato;
		this.firmanavn = firmanavn;
		this.firmaTlf = firmaTlf;
		this.booking_hotel = booking_hotel;
		//association -->1 Deltager (tvungen association)
		this.deltager = deltager;
		konference = k;
		
	}
	
	public Booking_konference(LocalDate ankomstdato, LocalDate afrejsedato,	Booking_hotel booking_hotel, 
			Deltager deltager, Konference k) {
		this.ankomstdato = ankomstdato;
		this.afrejsedato = afrejsedato;
		this.booking_hotel = booking_hotel;
		//association -->1 Deltager (tvungen association)
		this.deltager = deltager;
		konference = k;
	}
	
	
	public double totalPris() {

		double ledsagerpris;
		double værelsesPris = 0;
		double serviceYdelsePris = 0;
		double konferencePris;
		double pris;
		double daysBetween = ChronoUnit.DAYS.between(ankomstdato, afrejsedato);
		
		if(deltager.getLedsager() != null) {
			ledsagerpris = deltager.getLedsager().totalUdflugtspris();
		}else {
			ledsagerpris = 0;
		}

		
		//hotelværeslespris
		if(booking_hotel.getHotel() != null) {
			if(deltager.getLedsager() != null) {
				værelsesPris = getBooking_hotel().getHotel().getDobbeltvaerelse() * daysBetween;
			} else {
				værelsesPris = getBooking_hotel().getHotel().getEnkeltvaerelse() * daysBetween;
			}

			//ydelsespris
			for(int i = 0; i < booking_hotel.getServiceydelser().size() ; i++) {
				if(booking_hotel.getServiceydelser() != null) {
					serviceYdelsePris += booking_hotel.getServiceydelser().get(i).getYdelsespris() * daysBetween;
				}else {
					serviceYdelsePris = 0;
				}
			}
		}
		
		double daysBetweenKonference = ChronoUnit.DAYS.between(ankomstdato, afrejsedato.plusDays(1));
		
		if(deltager.getForedragsholder() == true) {
			konferencePris = 0;
		}else {

			konferencePris = konference.getPris() * daysBetweenKonference;
		}

		
		pris = ledsagerpris + værelsesPris + serviceYdelsePris + konferencePris;
		
		System.out.println("Konference.totalPris()...");
		System.out.println("Ledsagerpris: " + ledsagerpris);
		System.out.println("Værelsespris: " + værelsesPris);
		System.out.println("Serviceydelsespris: " + serviceYdelsePris);
		System.out.println("Konferencepris: " + konferencePris);
		System.out.println("Overnatninger: " + daysBetween);
		
		return pris;
		
	}
	
	
	
	//get-metoder
	
	public LocalDate getAnkomstdato() {
		return ankomstdato;
	}

	public LocalDate getAfrejsedato() {
		return afrejsedato;
	}

	public String getFirmanavn() {
		return firmanavn;
	}

	public String getFirmaTlf() {
		return firmaTlf;
	}


	//association -->1 Deltager (tvungen association)
	
	public Deltager getDeltager() {
		return deltager;
	}
	
	
	//association -->0..1 Booking_hotel
	
	@Override
	public String toString() {
		return "Booking_konference [firmanavn=" + firmanavn + ", firmaTlf=" + firmaTlf + ", konference=" + konference
				+ "]";
	}

	public void setBooking_hotel(Booking_hotel booking_hotel) {
		if(this.booking_hotel != booking_hotel) {
			this.booking_hotel = booking_hotel;
		}
	}
	
	public Booking_hotel getBooking_hotel() {
		return booking_hotel;
	}	
	
	
	//association -->1 Konference (dobbelt-rettet: one-to-many)

	public Konference getKonference(){
		return konference;
	}
	
		//this method updates ArrayList "booking_konferencer" in Konference
	public void setKonference(Konference konference) {
		if(this.konference != konference) {
			Konference oldKonference = this.konference;
			if(oldKonference != null) {
				oldKonference.removeBooking_konferencer(this);
			}
			this.konference = konference;
			if(konference != null) {
				konference.addBooking_konference(this);
			}
		}
	}
	
}
