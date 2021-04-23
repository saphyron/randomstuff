package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Booking {

	private String passager;
	private String opsamlingssted;
	private LocalTime opsamlingstid;
	private Lift lift;
	private ArrayList<Anbefaling> af = new ArrayList<>();

	public Booking(String passager, String opsamlingssted, LocalTime opsamlingstid, Lift lift) {
		super();
		this.passager = passager;
		this.opsamlingssted = opsamlingssted;
		this.opsamlingstid = opsamlingstid;
		this.lift = lift;
	}
	
	@Override
	public String toString() {
		return this.passager + " " + this.opsamlingssted + " " + this.opsamlingstid;
	}

	public Anbefaling createAnbefaling(Stjerner stjerner, String kommentar) {
		Anbefaling anbefaling = new Anbefaling(stjerner, kommentar);
		af.add(anbefaling);
		return anbefaling;
	}

	public void removeAnbefaling(Anbefaling anbefaling) {
		if (af.contains(anbefaling)) {
			af.remove(anbefaling);
		}
	}

	public void setLift(Lift lf) {
		if (this.lift == null) {
			this.lift = lf;
			lf.addBooking(this);
		} else if (lf == null) {
			this.lift.removeBooking(this);
			this.lift = lf;
		} else if (this.lift != lf) {
			this.lift.removeBooking(this);
			this.lift = lf;
			lf.addBooking(this);
		}
	}

	public void removeLift() {
		this.lift = null;
	}

	public String getPassager() {
		return passager;
	}

	public String getOpsamlingssted() {
		return opsamlingssted;
	}

	public LocalTime getOpsamlingstid() {
		return opsamlingstid;
	}

	public Lift getLift() {
		return lift;
	}

	public ArrayList<Anbefaling> getAf() {
		return af;
	}

}
