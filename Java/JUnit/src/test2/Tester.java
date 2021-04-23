package test2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import forsikring.Bilforsikring;

public class Tester {
	Bilforsikring bil = new Bilforsikring();
	
	@Before
	public void testSetGrundpraemie() throws Exception {
//		Bilforsikring bil = new Bilforsikring();
		//Set setGrundpr�mie
		bil.setGrundpraemie(100);
	}
	
	@Test
	public void testberegnpraemie() {
		//Under 25, kvinde, 1 �r
		double b = bil.beregnpraemie(24, true, 1);
		//Over 25, kvinde, 1 �r
		double b1 = bil.beregnpraemie(26, true, 1);
		//Over 25, mand, 1 �r
		double b2 = bil.beregnpraemie(26, false, 1);
		//Over 25, kvinde, 3 �r
		double b3 = bil.beregnpraemie(26, true, 3);
		//Over 25, kvinde, 6 �r
		double b4 = bil.beregnpraemie(26, true, 6);
		//Over 25, kvinde, 8 �r
		double b5 = bil.beregnpraemie(28, true, 8);
		
		//Checker at not null
		assertNotNull(b);
		assertNotNull(b1);
		assertNotNull(b2);
		assertNotNull(b3);
		assertNotNull(b4);
		assertNotNull(b5);
		
		//Tester for correct value
		assertEquals(b, 118.75, 0.001);
		assertEquals(b1, 95, 0.001);
		assertEquals(b2, 100, 0.001);
		assertEquals(b3, 80.75, 0.001);
		assertEquals(b4, 71.25, 0.001);
		assertEquals(b5, 61.75, 0.001);
	}
	

}
