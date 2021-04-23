package Lektion10;

public class Konto {
	
	private int id;
	private KontoType kontoType;
	private double saldo;
	private String status;
	private static int bankNr = 1;
	
	public Konto(KontoType kontoType) {
		this.kontoType = kontoType;
		this.id = bankNr;
		this.saldo = 0;
		this.status = "�ben";
		bankNr++;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setKontoType(String kontoType) {
		//this.kontoType = kontoType;
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
