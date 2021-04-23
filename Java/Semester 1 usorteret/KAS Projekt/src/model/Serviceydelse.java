package model;

public class Serviceydelse {

	@Override
	public String toString() {
		return "Serviceydelse " +" [" + ydelsestype + "]" + "  (" + ydelsespris + ")";
	}





	private String ydelsestype;
	private double ydelsespris;
	
	public Serviceydelse(String ydelsestype, double ydelsespris) {
		this.ydelsestype = ydelsestype;
		this.ydelsespris = ydelsespris;
	}
	
	
	
	
	
	//get-metoder
	
	public String getYdelsestype() {
		return ydelsestype;
	}
	public double getYdelsespris() {
		return ydelsespris;
	}
	






	public void setYdelsesPris(double ydelsespris) {
		this.ydelsespris = ydelsespris;
		
	}
	
	
	
}
