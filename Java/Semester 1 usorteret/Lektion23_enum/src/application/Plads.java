package application;

import java.util.ArrayList;

public class Plads {

	private int nr;
	private Område område;
	private final ArrayList<Reservation> reservering = new ArrayList<>();
	private static double standardTimePris = 50;

	public Plads(int nr, Område område) {
		this.nr = nr;
		this.område = område;
	}

	public int getNr() {
		return nr;
	}

	public Område getOmråde() {
		return område;
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
			if (område == Område.STANDARD) {
				pris = standardTimePris * timer;
			} else if (område == Område.BØRNE) {
				pris = standardTimePris * 0.8 * timer;
			} else if (område == Område.TURNERING) {
				pris = standardTimePris * 1.1 * timer;
			} else if (område == Område.VIP) {
				pris = standardTimePris * 1.25 * timer;
			}
		return pris;
	}

}
