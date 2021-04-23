package model;

public class Anbefaling {
	
	private Stjerner stjerner;
	private String kommentar;
	
	
	public Anbefaling(Stjerner stjerner, String kommentar) {
		super();
		this.stjerner = stjerner;
		this.kommentar = kommentar;
	}


	public Stjerner getStjerner() {
		return stjerner;
	}


	public String getKommentar() {
		return kommentar;
	}
	
	
	
	

}
