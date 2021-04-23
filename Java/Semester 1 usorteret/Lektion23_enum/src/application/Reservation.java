package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
	
	private LocalDateTime start;
	private LocalDateTime slut;
	private final ArrayList<Plads> pladser = new ArrayList<>();
	
	public Reservation(LocalDateTime start, LocalDateTime slut) {
		this.slut = slut;
		this.start = start;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getSlut() {
		return slut;
	}
	
	public ArrayList<Plads> getPlads() {
		return new ArrayList<>(pladser);
	}
	
	public void addPlads(Plads plads) {
		if (!pladser.contains(plads)) {
			pladser.add(plads);
			plads.addReservation(this);
		}
	}
	
	public void removePlads(Plads plads) {
		if (pladser.contains(plads)) {
			pladser.remove(plads);
			plads.removeReservation(this);
		}
	}

}
