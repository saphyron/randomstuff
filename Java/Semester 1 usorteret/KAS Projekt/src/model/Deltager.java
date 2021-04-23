package model;

import java.util.ArrayList;

public class Deltager {

	@Override
	public String toString() {
		return "Deltager " + navn;
	}
	private String navn;
	private String telefon;
	private String adresse;
	private String by;
	private String land;
	private boolean foredragsholder;
	//association -->0..1 Ledsager
	private Ledsager ledsager;
	
	
	public Deltager(String navn, String telefon, String adresse, String by, String land, boolean foredragsholder) {
		this.navn = navn;
		this.telefon = telefon;
		this.adresse = adresse;
		this.by = by;
		this.land = land;
		this.foredragsholder = foredragsholder;

	}

	
	//set metoder
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public void setForedragsholder(boolean foredragsholder) {
		this.foredragsholder = foredragsholder;
	}

	
	
	// get-metoder
	
	public boolean getForedragsholder(){
		return foredragsholder;
	}
	
	public String getNavn() {
		return navn;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getBy() {
		return by;
	}

	public String getLand() {
		return land;
	}
	
	
	//Association -->0..1 Ledsager
	
	public Ledsager getLedsager() {
		return ledsager;
	}
	public void setLedsager(Ledsager ledsager) {
		if(this.ledsager != ledsager) {
			this.ledsager = ledsager;
		}
	}







	
	
}
