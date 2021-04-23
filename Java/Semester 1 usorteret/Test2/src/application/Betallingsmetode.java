package application;

/**
 * Enum for de forskellige betallingsmetoder. De
 * er af typen Enum fordi der ikke
 * skal tilføjes ydelige betallingsmetoder 
 * i runtime.
 * 
 * @author gruppe 5
 * @see    Kvittering
 */

public enum Betallingsmetode {
	DANKORT {
	    @Override public String toString() {
	        return "Dankort";
	      }
	}, 	
	MOBILEPAY{
	    @Override public String toString() {
	        return "MobilePay";
	      }
	}, 
	KONTANT{
	    @Override public String toString() {
	        return "Kontant";
	      }
	}, 
	KLIPPEKORT{
	    @Override public String toString() {
	        return "Klippekort";
	      }
	}, 
	REGNING{
	    @Override public String toString() {
	        return "Regning";
	      }
	}, 
}
