package eksempler;

public class Person {
	
	private int alder;
	private String navn;
	
	public Person(String navn, int alder) {
		this.navn = navn;
		this.alder = alder;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public int getAlder() {
		return alder;
	}
}
