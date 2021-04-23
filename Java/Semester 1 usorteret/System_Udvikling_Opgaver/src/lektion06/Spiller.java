package lektion06;

public class Spiller {
	
	private String navn;
	private String position;
	private String status;
	private int alder;
	
	public Spiller(String navn, int alder) {
		this.alder = alder;
		this.navn = navn;
		this.position = "(Ikke fastlagt)";
		this.status = "(Ikke fastlagt)";
	}
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAlder() {
		return alder;
	}
	public void setAlder(int alder) {
		this.alder = alder;
	}
	
	public void printStatus() {
		System.out.println("Spillerens navn er " + navn + ".");
		System.out.println("spilleren er " + alder + " år gammel.");
		System.out.println("Spilleren status er " + status + ".");
		System.out.println("spillere har " + position + " som position.");		
	}

}
