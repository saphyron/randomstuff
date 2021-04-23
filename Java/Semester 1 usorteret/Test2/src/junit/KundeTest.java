package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Kunde;

public class KundeTest {
	Kunde kunde = new Kunde("Navn", false, false);

	@Test
	public void test() {
		
		
	try {	
		kunde.setNavn(null);
	} catch (IllegalArgumentException e) {
		assertTrue(e.getMessage().equals("Fejl! Kunde instans kan ikke laves: Navn er null"));
	}
	
	try {
		kunde.setNavn("");
	} catch (IllegalArgumentException e) {
		assertTrue(e.getMessage().equals("Fejl! Kunde instans kan ikke laves: Navn er tom"));
	}
	
	try {
		kunde.setKundeNr(-1);
	} catch (IllegalArgumentException e) {
		assertTrue(e.getMessage().equals("Fejl! Kunde instans kan ikke laves: KundeNr er negativt"));
	}
	
	try {
		new Kunde("Navn2", true, true);

	} catch (Exception e) {
		assertTrue(e.getMessage().equals("Fejl! Kunde instans kan ikke laves: Kunde kan ikke både"
				+ "være studerende og erhvervsskunde"));
	}
	
	}
}
