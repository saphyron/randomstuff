package model;

public class IndkoebsturApp {

	public static void main(String[] args) {
		Varer vin = new Spiritus(85, "Vodka", "35% Vodka", 0.35, new SpritusUnder90Moms());
		Varer vin2 = new Spiritus(91, "Vodka Camella", "40% Vodka", 0.4, new SpritusOver90Moms());
		Varer mad = new Foedevarer(56, "Pizza", "Fryse Pizza", 90, new FoedevarerMoms());
		Varer el = new ElArtikel(100, "El-keddel", "3000watt", 3, new ElArtiklerMoms());
		Varer andet = new Varer(40, "Deodorant", "Axe", new AndreVarerMoms());
		
		System.out.println(vin.getNavn() + " efter moms koster: " + vin.beregnMoms());
		System.out.println(vin2.getNavn() + " efter moms koster: " + vin2.beregnMoms());
		System.out.println(mad.getNavn() + " efter moms koster: " + mad.beregnMoms());
		System.out.println(el.getNavn() + " efter moms koster: " + el.beregnMoms());
		System.out.println(andet.getNavn() + " efter moms koster: " + andet.beregnMoms());

	}

}
