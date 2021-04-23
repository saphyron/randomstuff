package application;

import java.util.ArrayList;

public class Plads {

	private int nr;
	private Omr�de omr�de;
	private final ArrayList<Reservation> reservering = new ArrayList<>();
	private static double standardTimePris = 50;

	public Plads(int nr, Omr�de omr�de) {
		this.nr = nr;
		this.omr�de = omr�de;
	}

	public int getNr() {
		return nr;
	}

	public Omr�de getOmr�de() {
		return omr�de;
	}

	public static double getStandardTimePris() {
		return standardTimePris;
	}

	public static void setStandardTimePris(double standardTimePris) {
		Plads.standardTimePris = standardTimePris;
	}

	public ArrayList<Reservation> getReservation() {
		return new ArrayList<>(reservering);
	}

	public void addReservation(Reservation reservation) {
		if (!reservering.contains(reservation)) {
			reservering.add(reservation);
			reservation.addPlads(this);
		}
	}

	public void removeReservation(Reservation reservation) {
		if (reservering.contains(reservation)) {
			reservering.remove(reservation);
			reservation.removePlads(this);
		}
	}

	public double pris(int timer) {
		double pris = 0;
			if (omr�de == Omr�de.STANDARD) {
				pris = standardTimePris * timer;
			} else if (omr�de == Omr�de.B�RNE) {
				pris = standardTimePris * 0.8 * timer;
			} else if (omr�de == Omr�de.TURNERING) {
				pris = standardTimePris * 1.1 * timer;
			} else if (omr�de == Omr�de.VIP) {
				pris = standardTimePris * 1.25 * timer;
			}
		return pris;
	}

}
