package application;



public class Bil {
	
	private String regNr;
	private EnumBilmærke bilmærke;
	
	public Bil(String regNr, EnumBilmærke bilmærke) {
		this.regNr = regNr;
		this.bilmærke = bilmærke;
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

	public EnumBilmærke getBilmærke() {
		return bilmærke;
	}

	public void setBilmærke(EnumBilmærke bilmærke) {
		this.bilmærke = bilmærke;
	}

	
	

}
