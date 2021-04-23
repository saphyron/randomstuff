package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {

	private String navn;
	private double pris;
	private LocalDate startdato;
	private LocalDate slutdato;
	private LocalDate tilmeldingsfrist;
	//association -->0..* Udflugt
	private ArrayList<Udflugt> udflugter = new ArrayList<>();
	//association -->0..* Booking_konference (dobbelt-rettet)
	private final ArrayList<Booking_konference> booking_konferencer = new ArrayList<>();
	//association -->0..* Hotel (Dobbelt-rettet: many-to-many)
	private final ArrayList<Hotel> hoteller;
	
	
	public Konference(String navn, double pris, LocalDate startdato, LocalDate slutdato, LocalDate tilmeldingsfrist) {
		this.navn = navn;
		this.pris = pris;
		this.startdato = startdato;
		this.slutdato = slutdato;
		this.tilmeldingsfrist = tilmeldingsfrist;
		hoteller = new ArrayList<>();
	}
	
	

	
	//set-metoder
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public void setStartdato(LocalDate startdato) {
		this.startdato = startdato;
	}

	public void setSlutdato(LocalDate slutdato) {
		this.slutdato = slutdato;
	}

//	@Override
//	public String toString() {
//		return "Konference [navn=" + navn + ", pris=" + pris + ", startdato=" + startdato + ", slutdato=" + slutdato
//				+ ", tilmeldingsfrist=" + tilmeldingsfrist + "]";
//	}


	@Override
	public String toString() {
		return navn;
	}

	
	


	public void setTilmeldingsfrist(LocalDate tilmeldingsfrist) {
		this.tilmeldingsfrist = tilmeldingsfrist;
	}


	//get-metoder


	public String getNavn() {
		return navn;
	}

	public double getPris() {
		return pris;
	}

	public LocalDate getStartdato() {
		return startdato;
	}

	public LocalDate getSlutdato() {
		return slutdato;
	}

	public LocalDate getTilmeldingsfrist() {
		return tilmeldingsfrist;
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}
	
	public void addUdflugt(Udflugt udflugt) {
		if(!udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
		}
	}
	
	public void removeUdflugt(Udflugt udflugt) {
		if(udflugter.contains(udflugt)) {
			udflugter.contains(udflugt);
		}
	}
	
	
	//association -->0..* Booking_konference (dobbelt-rettet: one-to-many)
	
	public ArrayList<Booking_konference> getBooking_konferencer(){
		return new ArrayList<>(booking_konferencer);
	}
	
	public void addBooking_konference(Booking_konference booking_konference) {
		if(!booking_konferencer.contains(booking_konference)) {
			booking_konferencer.add(booking_konference);
			booking_konference.setKonference(this);
		}
	}
	
	public void removeBooking_konferencer(Booking_konference booking_konference) {
		if(booking_konferencer.contains(booking_konference)) {
			booking_konferencer.remove(booking_konference);
			booking_konference.setKonference(null);
		}
	}
	
	
	// association -->0..* Hotel (Dobbelt-rettet: many-to-many)
	
	public ArrayList<Hotel> getHoteller(){
		return new ArrayList<>(hoteller);
	}
	
	public void addHotel(Hotel hotel) {
		if(!hoteller.contains(hotel)) {
			hoteller.add(hotel);
			hotel.addKonference(this);
		}
	}
	
	public void removeHotel(Hotel hotel) {
		if(hoteller.contains(hotel)) {
			hoteller.remove(hotel);
		}
	}
	
	
	
	
}
