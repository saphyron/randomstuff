package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Andet;
import application.ProduktType;

public class AndetTest {


	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		Andet andet = new Andet("Andet", produktType, "Beskrivelsen");
		
		try {
			andet.setBeskrivelse(null);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Beskrivelsen kan ikke være null."));
		}
		
		try {
			andet.setBeskrivelse("");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Beskrivelsen kan ikke være tom."));
		}
		try {
			andet.setBeskrivelse(" ");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Beskrivelsen er kun mellemrum."));
		}
		try {
			andet.setNavn("");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Navn kan ikke være tom."));
		}
	}

}
