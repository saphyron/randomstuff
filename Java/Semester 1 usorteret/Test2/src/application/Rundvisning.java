package application;

/**
 * Nedavningsklasse med special attributter 
 * som dato, tid og antal besøgende
 * (double).
 *
 * @author Gruppe 5
 * @see    Produkt
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Rundvisning extends Produkt implements java.io.Serializable {

	//Attributter: Imported java.time.LocalDato / LocalTime for at attributter virker.
	private LocalDate dato;
	private LocalTime tid;
	private int besøgende;
	private static final int MAKSBESØGENDE = 75;
	private static final long serialVersionUID = 123123123;
	
	/**
	 * Til at skabe et produkt af gruppen rundvisning.
	 * @param navn som er en string. Nedarvet fra Produkt klassen.
	 * @param dato != før dagens dato. Dato rundvisning sker.
	 * @param tid på dagen rundvisning sker.
	 * @param besøgende TODO
	 * @param prisliste for at tilkoble den til en prisliste. Nedarvet fra produkt klassen.
	 * @throws IllegalArgumentException hvis dato er før dagens dato.
	 * @throws IllegalArgumentException hvis tid er udenfor dags timerne.
	 */
	
	public Rundvisning(String navn, LocalDate dato, LocalTime tid, ProduktType produktType) {
		super(navn, produktType);
		if(dato.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Fejl! Rundvisning kan ikke ske før dagens dato.");
		}
		this.dato = dato;
		this.tid = tid;
	}
	//Getters og Setters
	public LocalDate getDato() {
		return dato;
	}
	
	public void setDato(LocalDate dato) {
		this.dato = dato;
	}
	
	public LocalTime getTid() {
		return tid;
	}
	
	public void setTid(LocalTime tid) {
		this.tid = tid;
	}
	
	public int getBesøgende() {
		return besøgende;
	}
	
	public void setBesøgende(int besøgende) {
		
		if (MAKSBESØGENDE < besøgende) {
			throw new IllegalArgumentException("For mange besøgende");
		}
		
		this.besøgende = besøgende;
	}
	
	public void incrementBesøgende(int increment) {
		if (MAKSBESØGENDE < besøgende + increment) {
			throw new IllegalArgumentException("For mange besøgende");
		}
		
		besøgende = besøgende + increment;
	}
	
	@Override
	public String[][] getAttributter() {
		return new String[][] { 
			{ "Dato", ""+dato},
			{ "Tid", ""+tid},
			{ "Besøgende", ""+besøgende},
			{ "Max besøgende", ""+MAKSBESØGENDE}
		};
	}
	
	
}
