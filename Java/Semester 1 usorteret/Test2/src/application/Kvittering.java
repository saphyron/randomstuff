package application;

/*
 * Enhvert salg i systemet bliver gemt i
 * denne klasse. For hver pris
 * kunden køber vil en klasse af typen
 * kvitteringslinje blive tilføjet
 * til associeringen. Når metoden
 * betal() bliver kaldt skal
 * instansen gemmes i storage,
 * og kvitteringslinjerne må
 * hverken tilføjes eller fjenes.
 * 
 * @author gruppe 5
 * @see    Kvitteringslinje
 * @see    Kunde
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Kvittering implements java.io.Serializable{
	private static final long serialVersionUID = 123123123;
	private double nettoPris = 0.0;
	private Betallingsmetode betallingsmetode;
	private LocalDate datoForBetalling;
	private LocalTime tidForBetalling;
	private Kunde kunde;
	private boolean harBetalt;
	private List<KvitteringsLinje> kvitteringsLinjer = new ArrayList<>();
	private LocalDate senestBetallingsDato;
	private RabatBehavior rabatBeregner = new StdRabat();
	/*
	 * LocalDate variable bruges kun hvis en kunde 
	 * først bestiller og senere
	 * betaler kvitteringen på aflevering
	 */
	/**
	 * Skaber en ny kvittering.
	 * @param kunde er en associations klasse.
	 * @throws IllegalArgumentException hvis kunde er null.
	 */
	public Kvittering(Kunde kunde) {
		if (kunde == null) {
			throw new IllegalArgumentException("Fejl! Kvittering instans kan ikke laves: kunde er null");
		}
		this.kunde = kunde;
	}
	/**
	 * Tilføjer en kvitteringslinje.
	 * @param pris er en associations klasse.
	 * @param antal er en int værdi der ikke kan være negativ eller 0.
	 * @throws IllegalArgumentException hvis kvittering er allerede betalt.
	 */
	public void addKvitteringsLinje(Pris pris, int antal) {
		if (harBetalt) {
			throw new IllegalStateException("Fejl! Kvittering er allerede betalt");
		}
		KvitteringsLinje kvitteringslinje = new KvitteringsLinje(pris, antal);
		for (KvitteringsLinje kvitteringsLinje : kvitteringsLinjer) {
			if (kvitteringsLinje.getPris().equals(pris)) {
				kvitteringsLinje.setAntal(kvitteringsLinje.getAntal() + antal);
				return;
			}
		}
		kvitteringsLinjer.add(kvitteringslinje);
	}
	/**
	 * Fjerner en kvitteringslinje.
	 * @param kvitteringsLinje er en associations klasse.
	 */
	public void removeKvitteringsLinje(KvitteringsLinje kvitteringsLinje) {
		if (kvitteringsLinjer.contains(kvitteringsLinje)) {
			kvitteringsLinjer.remove(kvitteringsLinje);
		}
	}
	public Iterator<KvitteringsLinje> getIterator() {
		return kvitteringsLinjer.iterator(); 
	}
	/**
	 * Laver en betaling på tidspunktet.
	 * @param betallingsmetode er en associations klasse.
	 */
	public void betal(Betallingsmetode betallingsmetode) {
		betal(betallingsmetode, LocalDate.now(), LocalTime.now().withNano(0));  
	}
	/**
	 * Laver en betaling.
	 * @param betallingsmetode er en associations klasse.
	 * @param datoForBetalling dato for betaling.
	 * @param tidForBetalling tid for betaling.
	 * @throws IllegalArgumentException hvis kvittering er betalt.
	 * @throws IllegalArgumentException hvis betalingsmetode er null.
	 * @throws IllegalArgumentException hvis dato eller tid er null.
	 * @throws IllegalArgumentException hvis betalingsdato er før dagens dato.
	 */
	public void betal(Betallingsmetode betallingsmetode, LocalDate datoForBetalling, LocalTime tidForBetalling) {
		if (harBetalt) {
			throw new IllegalStateException("Fejl! Kvittering er allerede betalt");
		}
		if (betallingsmetode == null) {
			throw new IllegalArgumentException("Fejl! Betallingsmetode Enum er null");
		}
		if (datoForBetalling == null || tidForBetalling == null) {
			throw new IllegalArgumentException("Fejl! Dato eller tid er null");
		}
		if (datoForBetalling.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Fejl! Dato for bestillingen er før i dag.");
		}

		for (KvitteringsLinje kvitteringsLinje : kvitteringsLinjer) {
			Produkt produkt = kvitteringsLinje.getPris().getProdukt();
			if (produkt instanceof Rundvisning) {
				Rundvisning rundvisning = (Rundvisning) produkt;
				rundvisning.setBesøgende(rundvisning.getBesøgende() + kvitteringsLinje.getAntal());
			}
			
		}
		
		this.betallingsmetode = betallingsmetode;
		this.datoForBetalling = datoForBetalling;
		this.tidForBetalling = tidForBetalling;
		getNettoPris();
		harBetalt = true;
		
		kunde = new Kunde(new String (kunde.getNavn()), kunde.getIsStudent(), kunde.isErhverv());
	}
	public void clear() {
		kvitteringsLinjer = new ArrayList<>();
	}
	/**
	 * Metode for udregning af den samlede pris.
	 * Efter metodekaldet kan der ikke tilføjes 
	 * eller fjenes nye kvitteringslinjer
	 * 
	 * @return double
	 */
	public double getNettoPris() {
		if (harBetalt) {
			return nettoPris;
		}
		nettoPris = 0.0;
		kvitteringsLinjer.forEach(kl -> nettoPris += kl.getAntal() * kl.getStkPris());
		return rabatBeregner.beregnRabat(nettoPris, kunde.isErhverv(), kunde.getIsStudent());		
	}
	public Betallingsmetode getBetallingsmetode() {
		return betallingsmetode;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public List<KvitteringsLinje> getKvitteringsLinjer() {
		return kvitteringsLinjer;
	}
	@Override
	public String toString() {
		if (harBetalt) {
			return ("" + datoForBetalling).substring(2) + " " + kunde.getNavn() + ": " + nettoPris + " kr";
		}
		else {
			return "Senest:" + senestBetallingsDato + " " + kunde.getNavn() + ": pris: " + nettoPris;
		}
	}
	public LocalDate getSenestBetallingsDato() {
		return senestBetallingsDato;
	}
	public void setSenestBetallingsDato(LocalDate senestBetallingsDato) {
		this.senestBetallingsDato = senestBetallingsDato;
	}
	public LocalDate getDatoForBetalling() {
		return datoForBetalling;
	}
	public LocalTime getTidForBetalling() {
		return tidForBetalling;
	}
}
