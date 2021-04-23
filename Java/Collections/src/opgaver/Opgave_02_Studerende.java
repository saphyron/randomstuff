package opgaver;

import java.util.List;

public class Opgave_02_Studerende {
	
	private int studieNr;
	private String navn;
	private List<Integer> karakter;
	public Opgave_02_Studerende(int studieNr, String navn, List<Integer> karakter) {
		super();
		this.studieNr = studieNr;
		this.navn = navn;
		this.karakter = karakter;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public List getKarakter() {
		return karakter;
	}
	public int getStudieNr() {
		return studieNr;
	}
	
	public void addKarakter(int karakter) {
		this.karakter.add(karakter);
	}
	
	@Override
	public String toString() {
		return "Opgave_02_Studerende [studieNr=" + studieNr + ", navn=" + navn + ", karakter=" + karakter + "]";
	}
	
	

}
