package storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import application.*;

public class Storage {

	// Singleton instans for Storage.

	public Storage() {}
	
	private List<Kvittering> ubetalteKvitteringer = new ArrayList<>();
	private List<Produkt> produkter = new ArrayList<>();
	private List<ProduktType> produktTyper = new ArrayList<>();
	private List<Kunde> kunder = new ArrayList<>();
	private List<Prisliste> prislister = new ArrayList<Prisliste>();
	
	// -----------------------

	public void addProduktType(ProduktType produktType) {
		produktTyper.add(produktType);
	}

	// tilføj prisliste
	public void addPrisliste(Prisliste prisliste) {
		prislister.add(prisliste);
	}

	// fjern prisliste
	public void removePrisliste(Prisliste prisliste) {
		prislister.remove(prisliste);
	}

	// Produkt
	public ArrayList<Produkt> getProdukter() {
		return new ArrayList<Produkt>(produkter);
	}

	// tilføj prodult
	public void addProdukt(Produkt produkt) {
		produkter.add(produkt);
	}

	// fjern produkt
	public void removeProdukt(Produkt produkt) {
		produkter.remove(produkt);
	}

	public List<Prisliste> getPrislister() {
		return new ArrayList<Prisliste>(prislister);
	}
	
	public List<ProduktType> banlysteProduktTyper = new ArrayList<ProduktType>();
	
	public List<ProduktType> getbanlysteProduktTyper() {
		return null;
	}
	
	public List<Betallingsmetode> getBetallingsmetoder() {
		return Arrays.asList(Betallingsmetode.values());
	}
	public List<Kvittering> getUbetalteKvitteringer() {
		return new ArrayList<Kvittering>(ubetalteKvitteringer);
	}
	
	public void addKunde(Kunde kunde) {
		kunder.add(kunde);
	}
	
	public void removeKunde(Kunde kunde) {
		if (kunder.contains(kunde)) {
			kunder.remove(kunde);
		}
	}
	
	public List<Kunde> getKunder() {
		return new ArrayList<Kunde>(kunder);
	}
	
	public void addUbetaltKvittering(Kvittering kvittering) {
		ubetalteKvitteringer.add(kvittering);
	}
	public void removeUbetaltKvittering(Kvittering kvittering) {
		
		if (ubetalteKvitteringer.contains(kvittering)) {
			ubetalteKvitteringer.remove(kvittering);
		}
			
	}
	
}
