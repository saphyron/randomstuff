package lektion06;

public class Konto {
	
	private int nr;
	private String kontoType;
	private double saldo;
	private String status;
	
	public Konto(String kontoType, int nr) {
		this.kontoType = kontoType;
		this.nr = nr;
		this.saldo = 0;
		this.status = "�ben";
	}
	
	public void setNr(int nr) {
		this.nr = nr;
	}
	
	public int getNr() {
		return nr;
	}
	
	public void setKontoType(String kontoType) {
		this.kontoType = kontoType;
	}
	
	public String getKontoType() {
		return kontoType;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void inds�tBel�b(int bel�b) {
		if(this.status.equalsIgnoreCase("�ben") || this.status.equalsIgnoreCase("l�st")) {
			this.saldo = this.saldo + bel�b;
		} else {
			System.out.println("Din konto er " + this.status + ". Kontakt banken");
		}

	}
	
	public void h�vBel�b(int bel�b) {
		if (this.status.equalsIgnoreCase("�ben")) {
			this.saldo = this.saldo - bel�b;
		} else {
			System.out.println("Din konto er " + this.status + ". Kontakt banken");
		}
	}
	
	public void lukKonto() {
		this.status = "Lukket";
	}

}
