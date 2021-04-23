package elaboration;

import application.*;

public class ElaborationMainApp {

	public static void main(String[] args) {
		ProduktType pt1 = new ProduktType("øl");
		Produkt p1 = new Alkohol("juleøl", 10.5, 0.6, 2.0, pt1);
		Pris pr1 = new Pris(80, p1);
		Kunde k1 = new Kunde("David", false, false);
		Kvittering kvittering = new Kvittering(k1);
		kvittering.addKvitteringsLinje(pr1, 5);
		kvittering.betal(Betallingsmetode.DANKORT);
	}
}
