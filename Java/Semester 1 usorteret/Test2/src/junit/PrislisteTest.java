package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Prisliste;

public class PrislisteTest {
	Prisliste prisliste;

	@Test
	public void test() {
		
		try {
			prisliste = new Prisliste(null);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Prisliste instans kan ikke laves: Navn er null"));
		}
		
		try {
			prisliste = new Prisliste("");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Prisliste instans kan ikke laves: Navn er tom"));
		}
	
	}

}
