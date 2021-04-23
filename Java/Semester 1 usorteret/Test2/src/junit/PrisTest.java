package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Pris;
import application.Produkt;
import application.ProduktType;


public class PrisTest {
	
	class EtProdukt extends Produkt {
		private static final long serialVersionUID = 1L;
		public EtProdukt(String navn, ProduktType produktType) {
			super(navn, produktType);
		}
		public String[][] getAttributter() {
			return null;
		}
	}

	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		Produkt produkt = new EtProdukt("navn", produktType);


		try {
			new Pris(-1, produkt);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Pris instans kan ikke laves: Input pris er negativ."));
			
		}	
		
		try {
			new Pris(0, null);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Pris instans kan ikke laves: Input produkt er null."));
		}
		
	}
	
}
