package application;



public class Bil {
	
	private String regNr;
	private EnumBilm�rke bilm�rke;
	
	public Bil(String regNr, EnumBilm�rke bilm�rke) {
		this.regNr = regNr;
		this.bilm�rke = bilm�rke;
	}
	

	@Override
	public String toString() {
		return regNr;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public EnumBilm�rke getBilm�rke() {
		return bilm�rke;
	}

	public void setBilm�rke(EnumBilm�rke bilm�rke) {
		this.bilm�rke = bilm�rke;
	}

	
	

}
