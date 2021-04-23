package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lift {

	private LocalDateTime tidspunkt;
	private int pris;
	private String fraAdresse;
	private String tilAdresse;
	private int maxAntalPassager;
	private Bil bil;
	private ArrayList<Booking> bs = new ArrayList<>();

	public Lift(LocalDateTime tidspunkt, int pris, String fraAdresse, String tilAdresse, int maxAntalPassager,
			Bil bil) {
		super();
		this.tidspunkt = tidspunkt;
		this.pris = pris;
		this.fraAdresse = fraAdresse;
		this.tilAdresse = tilAdresse;
		this.maxAntalPassager = maxAntalPassager;
		this.bil = bil;
	}

	public void addBooking(Booking booking) {
		if (!bs.contains(booking)) {
			bs.add(booking);
			booking.setLift(this);
		}
	}

	public void removeBooking(Booking booking) {
		if (bs.contains(booking)) {
			bs.remove(booking);
			booking.removeLift();
		}
	}

	public void removeBil() {
		this.bil = null;
	}

	public LocalDateTime getTidspunkt() {
		return tidspunkt;
	}

	public int getPris() {
		return pris;
	}

	public String getFraAdresse() {
		return fraAdresse;
	}

	public String getTilAdresse() {
		return tilAdresse;
	}

	public int getMaxAntalPassager() {
		return maxAntalPassager;
	}

	public Bil getBil() {
		return bil;
	}

	// - - - - - - - - - - - - - - - - - - - - - -
	// Opgave 2
	public boolean Ledigplads() {
		boolean plads = false;
		if (this.maxAntalPassager <= bs.size()) {
			plads = false;
		} else {
			plads = true;
		}
		return plads;
	}

	// - - - - - - - - - - - - - - - - - - - - - -
	// Opgave 4

	public interface Comparable<T> {
		public int compareTo(T o);
	}

	// - - - - - - - - - - - - - - - - - - - - - -

}
