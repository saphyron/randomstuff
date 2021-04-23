package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Alkohol;
import application.KvitteringsLinje;
import application.Pris;
import application.Produkt;
import application.ProduktType;



public class KvitteringsLinjeTest {			
	

	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		Produkt øl = new Alkohol("øl", 0, 0, 0, produktType);
		Pris pris = new Pris(20, øl);
		KvitteringsLinje kvitteringsLinje = new KvitteringsLinje(pris, 1, 1);
		
		try {
			new KvitteringsLinje(null, 1, 1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! KvitteringsLinje instans kan ikke laves: Pris er null"));

		}
		try {
			kvitteringsLinje.setAntal(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! KvitteringsLinje instans kan ikke laves: antal er negativt eller 0"));

		}
		
		
		try {
			kvitteringsLinje.setSpecialAftaltRabat(0);
			} catch (IllegalArgumentException e) {
				assertTrue(e.getMessage().equals("Fejl! KvitteringsLinje metode \'setSpecialAftaltRabat\' kan ikke udføres:"
						+ " specialAftaltRabat er negativt eller over 100. Rabat skal være mellem 0 og 100 (inklusivt)"));

			}
			
		}
		
}

