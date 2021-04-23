package opgave;

public abstract class Ansat {
	
	private String fornavn;
	private String efternavn;
	private String cpr;	
	
	public Ansat(String fornavn, String efternavn, String cpr) {		
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.cpr = cpr;
	}

	public String getFornavn() {
		return fornavn;
	}
	
	public String getEfternavn() {
		return efternavn;
	}
	
	public String getCpr() {
		return cpr;
	}
	
	public abstract double udregnLoen();

	@Override
	public String toString() {
		return fornavn + " " + efternavn;
	}
	
}
