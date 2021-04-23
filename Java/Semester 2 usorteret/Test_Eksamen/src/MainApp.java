import java.util.*;

public class MainApp {
	public static void main(String[] args) {

		Abonnement ab1 = new Abonnement(100, 1);
		Abonnement tp1 = new TimePakke(0, 3, 2);
		Abonnement up1 = new UdvidelsesPakke(50, 2, 2, 25);

		List<Abonnement> lt = new ArrayList<>();
		lt.add(ab1);
		lt.add(tp1);
		lt.add(up1);
		
		System.out.println(udregnPris(lt));
		System.out.println(ab1.abonnementsPris());
		System.out.println(tp1.abonnementsPris());
		System.out.println(up1.abonnementsPris());
	}

	public static double udregnPris(List<Abonnement> lt) {
		double pris =0;
		for (int i = 0; i < lt.size(); i++) {
			pris = pris + lt.get(i).abonnementsPris();
		}
		return pris;
	}

}
