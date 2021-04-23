package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import application.*;
import storage.Storage;

public class Controller {

	private static Controller singletonIntance;
	private Storage storage = new Storage();
	private ProduktType produktType;
	private Controller() {}

	public static Controller getSingletonIntance() {
		if (singletonIntance == null) {
			singletonIntance = new Controller();
		}
		return singletonIntance;
	}

	public Pris createPris(double prisiDkk, Produkt produkt, Prisliste prisliste) {
		Pris pris = new Pris(prisiDkk, produkt);
		prisliste.addPris(pris);
		return pris;
	}

	public Prisliste createPrisliste(String prislisteNavn) {
		Prisliste prisliste = new Prisliste(prislisteNavn);
		storage.addPrisliste(prisliste);
		return prisliste;
	}

	public Produkt createAlkohol(String navn, double alkoholProcent, double liter, double pant,
			ProduktType produktType) {
		Produkt alkohol = new Alkohol(navn, alkoholProcent, liter, pant, produktType);
		storage.addProdukt(alkohol);
		return alkohol;
	}

	public Produkt createSampakning(String navn, int antalØl, int antalGlas, ProduktType produktType) {
		Produkt sampakning = new Sampakning(navn, antalØl, antalGlas, produktType);
		storage.addProdukt(sampakning);
		return sampakning;
	}

	public Produkt createKulsyre(String navn, double vægt, double pant, ProduktType produktType) {
		Produkt kulsyre = new Kulsyre(navn, vægt, pant, produktType);
		storage.addProdukt(kulsyre);
		return kulsyre;
	}

	public Produkt createAndet(String navn, ProduktType produktType, String beskrivelse) {
		Produkt andet = new Andet(navn, produktType, beskrivelse);
		storage.addProdukt(andet);
		return andet;
	}

	public Produkt createAnlæg(String navn, double pant,
			ProduktType produktType) {
		Produkt anlæg = new Anlæg(navn, pant, produktType);
		storage.addProdukt(anlæg);
		return anlæg;
	}
		
	public Produkt createRundvisning(String navn, LocalDate dato, LocalTime tid, ProduktType produktType) {
		Produkt rundvisning = new Rundvisning(navn, dato, tid, produktType);
		storage.addProdukt(rundvisning);
		return rundvisning;
	}

	public List<Produkt> getProdukter() {
		return storage.getProdukter();
	}
	
	public ProduktType getProduktType() {
		return produktType;
	}

	public void setComparatorOnPriser(Comparator<Pris> comparator) {
		for (Prisliste prisliste : storage.getPrislister()) {
			for (ProduktType produktType : prisliste.getTreeMapPriser().keySet()) {
				for (Pris pris : prisliste.getTreeMapPriser().get(produktType)) {
					pris.setComparator(comparator);
				}
			}
		}
	}
	
	public List<Pris> getAnlægProdukter() {
		
		/*if (Storage.getPrislister().contains("anlæg")) {
			System.out.println("oh no!");
		} */
		return storage.getPrislister().get(0).getTreeMapPriser().get(createProduktType("Anlæg"));
	}

	public Kunde createKunde(String navn, boolean isStudent, boolean isErhverv) {
		Kunde kunde = new Kunde(navn, isStudent, isErhverv);
		storage.addKunde(kunde);
		Kunde.antalKunderTilmeldt++;
		return kunde;
	}
	
	
	public List<Kunde> getKunder() {
		return storage.getKunder();
	}
	
	public void removeKunde(Kunde kunde) {
		storage.removeKunde(kunde);
	}
	public Kunde createKundeGæst(boolean isStudent) {
		Kunde kunde = new Kunde(isStudent);
		storage.addKunde(kunde);
		return kunde;
	}

	public Kvittering createKvittering(Kunde kunde) {
		Kvittering kvittering = new Kvittering(kunde);
		return kvittering;
	}

	private List<Comparator<Pris>> lstComparator = List.of(
			new PrisComparatorStkPrisStigende(),
			new PrisComparatorStkPrisAftagende(),
			new PrisComparatorAlfabetisk()
			);
	public List<Comparator<Pris>> getComparators() {
		return lstComparator;
	}
	
	
	public List<ProduktType> produktTyper = new ArrayList<>();
	
	public List<ProduktType> getProduktTyper() {
		return produktTyper;
	}
	
	public ProduktType createProduktType(String typeNavn) {
		ProduktType produktType = new ProduktType(typeNavn);
		produktTyper.add(produktType);
		return produktType;
	}

	public Kunde søgKunde(int kundeNr) {
		for (Kunde kunde : storage.getKunder()) {
			if (kunde.getKundeNr() == kundeNr) {
				return kunde;
			}
		}
		return null;
	}
	private List<Kvittering> betalKvitteringer = new ArrayList<>();
	public void betalKvittering(Betallingsmetode betallingsmetode, LocalDate date, LocalTime time, Kvittering kvittering) {
		kvittering.betal(betallingsmetode, date, time);
		betalKvitteringer.add(kvittering);
	}
	
	public void betalKvittering(Betallingsmetode betallingsmetode, Kvittering kvittering) {
		kvittering.betal(betallingsmetode);
		betalKvitteringer.add(kvittering);
	}
	public List<Kvittering> getBetalingsKvitteringer() {
		return new ArrayList<Kvittering>(betalKvitteringer);
	}
	
	public List<Prisliste> getPrislister() {
		return storage.getPrislister();
	}
	
	public List<Kvittering> getUbetalteKvitteringer() {
		return storage.getUbetalteKvitteringer();
	}
	
	public void addUbetaltKvitteringer(Kvittering kvittering) {
		storage.addUbetaltKvittering(kvittering);
	}
	
	public void removeUbetaltKvitteringer(Kvittering kvittering) {
		storage.removeUbetaltKvittering(kvittering);
	}
	
	public List<Betallingsmetode> getBetallingsmetoder() {
		return storage.getBetallingsmetoder();
	}
	
	public void init() {
		// Create Gæstekunde (isStudent)
		createKundeGæst(true);
		// Create Kunder (Navn, isStudent, isErhverv)
		createKunde("Joakim", true, false);
		Kunde k2 = createKunde("Christian", false, true);
		createKunde("John", true, false);
		createKunde("Peter", false, false);
		// Create Prislister (navn)
		Prisliste PrisListeButik = createPrisliste("Butik");
		Prisliste PrisListeBar = createPrisliste("Bar");
		// Create produkttyper (typeNavn)
		ProduktType pt1 = createProduktType("Fadøl, 40 cl");
		ProduktType pt2 = createProduktType("Spiritus");
		ProduktType pt3 = createProduktType("Sampakning");
		ProduktType pt4 = createProduktType("Flask");
		ProduktType pt5 = createProduktType("Fustage");
		ProduktType pt6 = createProduktType("Kulsyre");
		ProduktType pt7 = createProduktType("Klippekort");
		ProduktType pt8 = createProduktType("Malt");
		ProduktType pt9 = createProduktType("Beklædning");
		ProduktType pt10 = createProduktType("Anlæg");
		ProduktType pt11 = createProduktType("Glas");
		ProduktType pt12 = createProduktType("Rundvisning");
		//Banlyste produkter
		//banlysteProduktTyper.add(pt10);
		//banlysteProduktTyper.add(pt12);
		// Create produkter til produkttyper.
		// Flaske (navn, alkoholProcent, liter, pant, produktType);
		Produkt f1 = createAlkohol("Klosterbryg", 5, 0.6, 1.0, pt4);
		Produkt f2 = createAlkohol("Sweet Georgia Brown", 5, 0.6, 1.0, pt4);
		Produkt f3 = createAlkohol("Extra Pilsner", 5, 0.6, 1.0, pt4);
		Produkt f4 = createAlkohol("Celebration", 5, 0.6, 1.0, pt4);
		Produkt f5 = createAlkohol("Blondie", 5, 0.6, 1.0, pt4);
		Produkt f6 = createAlkohol("Forårsbryg", 5, 0.6, 1.0, pt4);
		Produkt f7 = createAlkohol("India Pale Ale", 5, 0.6, 1.0, pt4);
		Produkt f8 = createAlkohol("Julebryg", 5, 0.6, 1.0, pt4);
		Produkt f9 = createAlkohol("Juletønden", 5, 0.6, 1.0, pt4);
		Produkt f10 = createAlkohol("Old Strong Ale", 5, 0.6, 1.0, pt4);
		Produkt f11 = createAlkohol("Fregatten Jylland", 5, 0.6, 1.0, pt4);
		Produkt f12 = createAlkohol("Imperial Stout", 5, 0.6, 1.0, pt4);
		Produkt f13 = createAlkohol("Tribute", 5, 0.6, 1.0, pt4);
		Produkt f14 = createAlkohol("Black Monster", 5, 0.6, 1.0, pt4);
		// Fadøl (navn, alkoholProcent, liter, pant, produktType);
		Produkt fa1 = createAlkohol("Klosterbryg", 5, 0.4, 1.0, pt1);
		Produkt fa2 = createAlkohol("Jazz Classic", 5, 0.4, 1.0, pt1);
		Produkt fa3 = createAlkohol("Extra Pilsner", 5, 0.4, 1.0, pt1);
		Produkt fa4 = createAlkohol("Celebration", 5, 0.4, 1.0, pt1);
		Produkt fa5 = createAlkohol("Blondie", 5, 0.4, 1.0, pt1);
		Produkt fa6 = createAlkohol("Forårsbryg", 5, 0.4, 1.0, pt1);
		Produkt fa7 = createAlkohol("India Pale Ale", 5, 0.4, 1.0, pt1);
		Produkt fa8 = createAlkohol("Julebryg", 5, 0.4, 1.0, pt1);
		Produkt fa9 = createAlkohol("Imperial Stout", 5, 0.4, 1.0, pt1);
		Produkt fa10 = createAlkohol("Special", 5, 0.4, 1.0, pt1);
		Produkt fa11 = createAlkohol("Æblebrus", 5, 0.4, 1.0, pt1);
		Produkt fa12 = createAlkohol("Chips", 0, 0.0, 0.0, pt1);
		Produkt fa13 = createAlkohol("Peanuts", 0, 0.0, 0.0, pt1);
		Produkt fa14 = createAlkohol("Cola", 0, 0.33, 1.0, pt1);
		Produkt fa15 = createAlkohol("Nikoline", 0, 0.33, 1.0, pt1);
		Produkt fa16 = createAlkohol("7-Up", 0, 0.33, 1.0, pt1);
		Produkt fa17 = createAlkohol("vand", 0, 0.4, 0.0, pt1);
		// Spiritus (navn, alkoholProcent, liter, pant, produktType);
		Produkt s1 = createAlkohol("Spirit of Aarhus", 20, 1.0, 3.0, pt2);
		Produkt s2 = createAlkohol("SOA med pind", 20, 1.0, 3.0, pt2);
		Produkt s3 = createAlkohol("Whisky", 20, 1.0, 3.0, pt2);
		Produkt s4 = createAlkohol("Liquor of Aarhus", 20, 1.0, 3.0, pt2);
		// Fustage (navn, alkoholProcent, liter, pant, produktType);
		Produkt fu1 = createAlkohol("Klosterbryg", 5, 20.0, 200.0, pt5);
		Produkt fu2 = createAlkohol("Jazz Classic", 5, 25.0, 200.0, pt5);
		Produkt fu3 = createAlkohol("Extra Pilsner", 5, 25.0, 200.0, pt5);
		Produkt fu4 = createAlkohol("Extra Pilsner", 5, 30.0, 200.0, pt5);
		Produkt fu5 = createAlkohol("Celebration", 5, 20.0, 200.0, pt5);
		Produkt fu6 = createAlkohol("Blondie", 5, 25.0, 200.0, pt5);
		Produkt fu7 = createAlkohol("Forårsbryg", 5, 20.0, 200.0, pt5);
		Produkt fu8 = createAlkohol("India Pale Ale", 5, 20.0, 200.0, pt5);
		Produkt fu9 = createAlkohol("Julebryg", 5, 20.0, 200.0, pt5);
		Produkt fu10 = createAlkohol("Julebryg", 5, 25.0, 200.0, pt5);
		Produkt fu11 = createAlkohol("Imperial Stout", 5, 20.0, 200.0, pt5);
		// Kulsyre (navn, vægt, pant, produktType);
		Produkt ku1 = createKulsyre("6 kg", 6.0, 1000, pt6);
		Produkt ku2 = createKulsyre("4 kg", 4.0, 1000, pt6);
		Produkt ku3 = createKulsyre("10 kg", 10.0, 1000, pt6);
		// Malt (navn, produktType, beskrivelse);
		Produkt ma1 = createAndet("25 kg sæk", pt8, "Malt sæk med 25 kg.");
		// Beklædning (navn, produktType, beskrivelse);
		Produkt bk1 = createAndet("T-shirt", pt9, "En T-shirt.");
		Produkt bk2 = createAndet("Polo", pt9, "En polo.");
		Produkt bk3 = createAndet("Cap", pt9, "En Cap.");
		// Glas (navn, produktType, beskrivelse);
		Produkt gl1 = createAndet("Glas", pt11, "Glas af forskellige størelser.");
		Produkt kv1 = createAndet("10 klip klippekort", pt7, "et klip er 25 kroner");
		
		// Sampakning (navn, antalØl, antalGlas, produktType);
		Produkt sp1 = createSampakning("Gaveæske 2 øl, 2 glas", 2, 2, pt3);
		Produkt sp2 = createSampakning("Gaveæske 4 øl", 4, 0, pt3);
		Produkt sp3 = createSampakning("Trækasse 6 øl", 6, 2, pt3);
		Produkt sp4 = createSampakning("Gavekurv 6 øl, 2 glas", 6, 2, pt3);
		Produkt sp5 = createSampakning("Trækasse 6 øl, 6 glas", 6, 6, pt3);
		Produkt sp6 = createSampakning("Trækasse 12 øl", 12, 0, pt3);
		Produkt sp7 = createSampakning("Papkasse 12 øl", 12, 0, pt3);
		// Rundvisning (navn, dato, tid, produktType);
		Produkt rv1 = createRundvisning("15 november", LocalDate.of(2025, 11, 15), LocalTime.of(12, 00), pt12);
		Produkt rv2 = createRundvisning("29 november", LocalDate.of(2025, 11, 29), LocalTime.of(17, 00), pt12);
		// Klippekort

		// Anlæg (navn, datoForAflevering, reserveringsStatus, produktType);
		Produkt an1 = createAnlæg("1-Hane", 100.0, pt10);
		Produkt an2 = createAnlæg("2-Haner", 100.0, pt10);
		Produkt an3 = createAnlæg("Bar med flere Haner", 100.0, pt10);
		Produkt an4 = createAnlæg("Levering", 0.0, pt10);
		Produkt an5 = createAnlæg("Krus", 2.0, pt10);

		// CreatePris
		// Butik
		// Flaske
		createPris(36, f1, PrisListeButik);
		createPris(36, f2, PrisListeButik);
		createPris(36, f3, PrisListeButik);
		createPris(36, f4, PrisListeButik);
		createPris(36, f5, PrisListeButik);
		createPris(36, f6, PrisListeButik);
		createPris(36, f7, PrisListeButik);
		createPris(36, f8, PrisListeButik);
		createPris(36, f9, PrisListeButik);
		createPris(36, f10, PrisListeButik);
		createPris(36, f11, PrisListeButik);
		createPris(36, f12, PrisListeButik);
		createPris(36, f13, PrisListeButik);
		createPris(36, f14, PrisListeButik);
		// Spiritus
		createPris(300, s1, PrisListeButik);
		createPris(350, s2, PrisListeButik);
		createPris(500, s3, PrisListeButik);
		createPris(175, s4, PrisListeButik);
		// Klippekort
		createPris(250, kv1, PrisListeButik);
		// Fustage
		createPris(775, fu1, PrisListeButik);
		createPris(625, fu2, PrisListeButik);
		createPris(575, fu3, PrisListeButik);
		createPris(690, fu4, PrisListeButik);
		createPris(775, fu5, PrisListeButik);
		createPris(700, fu6, PrisListeButik);
		createPris(775, fu7, PrisListeButik);
		createPris(775, fu8, PrisListeButik);
		createPris(775, fu9, PrisListeButik);
		createPris(698.75, fu10, PrisListeButik);
		createPris(775, fu11, PrisListeButik);
		// Kulsyre
		createPris(400, ku1, PrisListeButik);
		createPris(267, ku2, PrisListeButik);
		createPris(667, ku3, PrisListeButik);
		// Malt
		createPris(300, ma1, PrisListeButik);
		// Beklædning
		createPris(70, bk1, PrisListeButik);
		createPris(100, bk2, PrisListeButik);
		createPris(30, bk3, PrisListeButik);
		// Glas
		createPris(15, gl1, PrisListeButik);
		// Sampakning
		createPris(100, sp1, PrisListeButik);
		createPris(130, sp2, PrisListeButik);
		createPris(240, sp3, PrisListeButik);
		createPris(250, sp4, PrisListeButik);
		createPris(290, sp5, PrisListeButik);
		createPris(390, sp6, PrisListeButik);
		createPris(360, sp7, PrisListeButik);
		// Rundvisning
		createPris(100, rv1, PrisListeButik);
		createPris(120, rv2, PrisListeButik);
		// Anlæg
		createPris(250, an1, PrisListeButik);
		createPris(400, an2, PrisListeButik);
		createPris(500, an3, PrisListeButik);
		createPris(500, an4, PrisListeButik);
		createPris(60, an5, PrisListeButik);
		// Bar
		// Flaske
		createPris(50, f1, PrisListeBar);
		createPris(50, f2, PrisListeBar);
		createPris(50, f3, PrisListeBar);
		createPris(50, f4, PrisListeBar);
		createPris(50, f5, PrisListeBar);
		createPris(50, f6, PrisListeBar);
		createPris(50, f7, PrisListeBar);
		createPris(50, f8, PrisListeBar);
		createPris(50, f9, PrisListeBar);
		createPris(50, f10, PrisListeBar);
		createPris(50, f11, PrisListeBar);
		createPris(50, f12, PrisListeBar);
		createPris(50, f13, PrisListeBar);
		createPris(50, f14, PrisListeBar);
		// Fadøl
		createPris(30, fa1, PrisListeBar);
		createPris(30, fa2, PrisListeBar);
		createPris(30, fa3, PrisListeBar);
		createPris(30, fa4, PrisListeBar);
		createPris(30, fa5, PrisListeBar);
		createPris(30, fa6, PrisListeBar);
		createPris(30, fa7, PrisListeBar);
		createPris(30, fa8, PrisListeBar);
		createPris(30, fa9, PrisListeBar);
		createPris(30, fa10, PrisListeBar);
		createPris(15, fa11, PrisListeBar);
		createPris(10, fa12, PrisListeBar);
		createPris(10, fa13, PrisListeBar);
		createPris(15, fa14, PrisListeBar);
		createPris(15, fa15, PrisListeBar);
		createPris(15, fa16, PrisListeBar);
		createPris(10, fa17, PrisListeBar);
		// Spiritus
		createPris(300, s1, PrisListeBar);
		createPris(350, s2, PrisListeBar);
		createPris(500, s3, PrisListeBar);
		createPris(175, s4, PrisListeBar);
		// Klippekort
		createPris(250, kv1, PrisListeBar);
		// Kulsyre
		createPris(400, ku1, PrisListeBar);
		createPris(267, ku2, PrisListeBar);
		createPris(667, ku3, PrisListeBar);
		// Beklædning
		createPris(70, bk1, PrisListeBar);
		createPris(100, bk2, PrisListeBar);
		createPris(30, bk3, PrisListeBar);
		// Sampakning
		createPris(100, sp1, PrisListeBar);
		createPris(130, sp2, PrisListeBar);
		createPris(240, sp3, PrisListeBar);
		createPris(250, sp4, PrisListeBar);
		createPris(290, sp5, PrisListeBar);
		Pris pris = createPris(390, sp6, PrisListeBar);
		createPris(360, sp7, PrisListeBar);
		//- - - - - - - - - - - - - - - - -
		
		
		//start serial test
		/*
		Prisliste PrisListeGalaxyBar = createPrisliste("Hog's Head Inn");
		// Create produkttyper (typeNavn)
		ProduktType ptX = createProduktType("Sprit");


		Produkt fX = createAlkohol("Firewhiskey", 5, 0.6, 1.0, ptX);
		
		createPris(500, fX, PrisListeGalaxyBar);
		
		//end
		
		*/
		Kvittering kvittering = new Kvittering(k2);
		
		int antal = 5;
		kvittering.addKvitteringsLinje(pris, antal);
		betalKvittering(Betallingsmetode.DANKORT, LocalDate.of(2001, 9, 11), LocalTime.of(16, 15), kvittering);
		
		 
		 
	}
	
	public void loadSerialFile(String filenamePath) throws IOException, ClassNotFoundException {
	        FileInputStream fileIn = new FileInputStream(filenamePath);
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        Prisliste inputPrislisteInstance = (Prisliste) in.readObject();
	        storage.addPrisliste(inputPrislisteInstance);
	        in.close();
	        fileIn.close();
	}
    
	public Double UdregnIndtjenesteEfterMoms() {
		
		double sum = 0;
		double kvitteringsNettoPris;
		for (Kvittering kvittering : getBetalingsKvitteringer()) {
			
			kvitteringsNettoPris = kvittering.getNettoPris();
			
			if (!kvittering.getKunde().isErhverv()) {
				kvitteringsNettoPris = 0.8 * kvitteringsNettoPris;
			}
			
			sum += kvitteringsNettoPris;
		}
	
		return sum;
	}
	
	public int getAntalPriserSolg() {
		int sum = 0;
		for (Kvittering kvittering : getBetalingsKvitteringer()) {
			for (KvitteringsLinje kvitteringsLinje : kvittering.getKvitteringsLinjer()) {
				sum += kvitteringsLinje.getAntal();
			}
		
		}
		
		return sum;
	}
	
	
	public String mestSolgtePris() {
		
		HashMap<String, Integer> produkterHashMap = new HashMap<>();
		
		for (Kvittering kvittering : getBetalingsKvitteringer()) {
			for (KvitteringsLinje kvitteringsLinje : kvittering.getKvitteringsLinjer()) {
				
				String strPris = kvitteringsLinje.getPris().toString();
				if (!produkterHashMap.containsKey(strPris)) {
					produkterHashMap.put(strPris, kvitteringsLinje.getAntal());
				}
				else {
					produkterHashMap.put(strPris, 
							produkterHashMap.get(strPris) + kvitteringsLinje.getAntal());
					
				}
					
			}
		
		}
		
		String strBest = "";
		int intBest = 0;
		
		for (String key : produkterHashMap.keySet()) {
			
			if (produkterHashMap.get(key) > intBest) {
				strBest = key;
				intBest = produkterHashMap.get(key);
			}
		}
		return strBest + " (" + intBest + " gange)";
	}
	
}
