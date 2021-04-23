package test_packge;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;
import controller.Controller;
import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;

public class TesterCases {
	
	public static Patient dummyPatient = new Patient("231045-0637", "Kim", 70);
	public static Laegemiddel dummyLaegemiddel = new Laegemiddel("Morfin", 0.01, 0.01, 0.02, "mg");
	public static LocalDate start = LocalDate.of(2000, 1, 1);
	public static LocalDate slut = LocalDate.of(2000, 1, 14);
	public static LocalDate tidspunkt = LocalDate.of(2000, 1, 2);
	public static LocalTime time = LocalTime.of(10, 30);
	public static Dosis dummyDosis = new Dosis(time, 6);
	public static DagligFast dummyDaligFast = new DagligFast(start, slut, dummyLaegemiddel, 0, 2, 1, 1);
	public static Ordination dummyordination = new DagligFast(start, slut, dummyLaegemiddel, 0, 2, 1, 1);
	public static PN dummyPN = new PN(start, slut, dummyLaegemiddel, 6);
	
	PN pn;
	DagligFast df;
	DagligSkaev ds;  

	@Test
	public void testOpretPNFraController() {
		try {
			pn = Controller.opretPNOrdination(start, slut, dummyPatient, dummyLaegemiddel, 10);
		} catch (Exception e) {
			fail();
			return;
		}
		try {
			Controller.opretPNOrdination(start, slut, dummyPatient, dummyLaegemiddel, -10);
			fail();
		} catch (Exception e) {}
		try {
			Controller.opretPNOrdination(slut, start , dummyPatient, dummyLaegemiddel, 10);
			fail();
		} catch (IllegalArgumentException e) {	}
		try {
			Controller.opretPNOrdination(start , slut, null, dummyLaegemiddel, 10);
			fail();
		} catch (IllegalArgumentException e) {}
		try {
			Controller.opretPNOrdination(start , slut, dummyPatient, null, 10);
			fail();
		} catch (Exception e) {}
		try {
			Controller.opretPNOrdination(null , slut, dummyPatient, dummyLaegemiddel, 10);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testOpretDFFraController() {
		try {
			df = Controller.opretDagligFastOrdination(start, slut, dummyPatient, dummyLaegemiddel, 1, 1, 0, 2);
		} catch (Exception e) {
			fail();
			return;
		}
		try {
			Controller.opretDagligFastOrdination(start, slut, dummyPatient, dummyLaegemiddel, 1, 10, 0, 2);			
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("Fejl i input på controller kald")) fail(); 
		}
		try {
			Controller.opretDagligFastOrdination(start, slut, dummyPatient, dummyLaegemiddel, 1, 10, 0, 2);
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("Fejl i input på controller kald")) fail(); 
		}
		// ---------------
		try {
			Controller.opretDagligFastOrdination(start, slut, dummyPatient, dummyLaegemiddel, 1, 10, 0, 2);			
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("Fejl i input på controller kald")) fail(); 
		}
		// ---------------
		try {
			Controller.opretDagligFastOrdination(start, slut, dummyPatient, null, 1, 1, 0, 2);	
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("Fejl i input på controller kald")) fail(); 
		}
		// ------------------
	}

	@Test
	public void testDs() {
		try {

			ds = Controller.opretDagligSkaevOrdination(start, slut, dummyPatient, dummyLaegemiddel,
					new LocalTime[] { LocalTime.of(10, 20), LocalTime.of(15, 20) }, 
					new double[] { 1, 1.5 });
		} catch (Exception e) {
			fail();
			return;
		}
		try {
			Controller.opretDagligSkaevOrdination(slut, start, dummyPatient, dummyLaegemiddel,
					new LocalTime[] { LocalTime.of(10, 20), LocalTime.of(15, 20) }, 
					new double[] { 1, 1.5 });
			fail();
		} catch (Exception e) {}
		try {
			Controller.opretDagligSkaevOrdination(start, slut, dummyPatient, null,
					new LocalTime[] { LocalTime.of(15, 20), LocalTime.of(15, 20) }, 
					new double[] { 1, 1.5 });
			fail();
		} catch (IllegalArgumentException e) {	}
		try {
			Controller.opretDagligSkaevOrdination(start, slut, null, dummyLaegemiddel,
					new LocalTime[] { LocalTime.of(10, 20), LocalTime.of(15, 20) }, 
					new double[] { 1, 1.5 });
			fail();
		} catch (IllegalArgumentException e) {}
	}
	//Ordination Test
		@org.junit.Test
		public void testSetLaegemiddel() {
			dummyordination.setLaegemiddel(dummyLaegemiddel);
			assertNotNull(dummyLaegemiddel);
		}
		@org.junit.Test
		public void testGetLaegemiddel() {
			assertEquals(14, dummyordination.antalDage());
		}
		//Daglig Fast test
		@org.junit.Test
		public void testCreateDosis() {
			dummyDaligFast.createDosis(dummyDosis);
			assertNotNull(dummyDaligFast.getDoser()[0]);
		}
		@org.junit.Test
		public void testRemoveDosis() {
			dummyDaligFast.removeDosis(dummyDosis);
			assertEquals(null, dummyDaligFast.getDoser()[0]);
		}
		//PN Test
		@org.junit.Test
		public void testAddTidspunktOgDøgnTidspunkt() {
			dummyPN.addTidspunkt(tidspunkt);
			assertNotNull(dummyPN.getTidspunkter().get(0));
			assertEquals(0.43, dummyPN.doegnDosis(), 0.01);
			Controller controller = Controller.getController();
			controller.createSomeObjects();
			for (Patient patient : controller.getAllPatienter()) {
				System.out.println(patient.getOrdinationer());
			}
		}
}

