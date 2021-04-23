package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import application.*;

public class KvitteringTest {


	@Test
	public void test() {	
		
		Kunde kunde;
		kunde = new Kunde("Navn", false, false);
		Kvittering kvittering = new Kvittering(kunde);
			
	try {	
		kvittering = new Kvittering(null);
	} catch (IllegalArgumentException e) {
		assertTrue(e.getMessage().equals("Fejl! Kvittering instans kan ikke laves: kunde er null"));
	}
	
	
	ProduktType produktType;
	produktType = new ProduktType("øl");
	Produkt øl = new Alkohol("øl", 0, 0, 0, produktType);
	Pris pris = new Pris(20, øl);
			
	kvittering.addKvitteringsLinje(pris, 2);
	kvittering.betal(Betallingsmetode.DANKORT);
	try {
		kvittering.betal(Betallingsmetode.DANKORT);
	} catch(IllegalStateException e) {
		assertTrue(e.getMessage().equals("Fejl! Kvittering er allerede betalt"));
	}
	try {
		kvittering.setSenestBetallingsDato(LocalDate.now());
	} catch(IllegalStateException e) {
		assertTrue(e.getMessage().equals("Fejl! Dato for bestillingen er før i dag."));
	}	
}

}
