package application;

import java.util.ArrayList;


public class Arrangement {
	
	private String navn;
	private boolean offentlig;
	private final ArrayList<Reservation> reservering = new ArrayList<>();
	
	public Arrangement(String navn, boolean offentlig) {
		this.navn = navn;
		this.offentlig = offentlig;
	}

	public String getNavn() {
		return navn;
	}

	public boolean isOffentlig() {
		return offentlig;
	}
	
	public int antalReserveredePladser() {
		int antalPladser = 0;
		for (int i = 0; i < reservering.size(); i++) {
			for (int j = 0; j < reservering.get(i).getPlads().size(); j++) {
				antalPladser++;
			}
		}
		return antalPladser;
	}
	
	public ArrayList<Reservation> getReservation() {
		return new ArrayList<>(reservering);
	}
	
	public void addReservation(Reservation reservation) {
		if (!reservering.contains(reservation)) {
			reservering.add(reservation);
		}
	}
	
	public void removeReservation(Reservation reservation) {
		if (reservering.contains(reservation)) {
			reservering.remove(reservation);
		}
	}

}
