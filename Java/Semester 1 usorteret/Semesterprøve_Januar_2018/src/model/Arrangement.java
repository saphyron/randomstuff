package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {

	private String title;
	private LocalDate date;
	private LocalTime startTid;
	private LocalTime slutTid;
	private double pris;

	public Arrangement(String title, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
		this.date = date;
		this.pris = pris;
		this.slutTid = slutTid;
		this.startTid = startTid;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getStartTid() {
		return startTid;
	}

	public LocalTime getSlutTid() {
		return slutTid;
	}

	public double getPris() {
		return pris;
	}
	
	

}
