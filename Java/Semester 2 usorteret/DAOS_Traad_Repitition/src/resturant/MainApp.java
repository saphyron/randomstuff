package resturant;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Starter Kokken og de 2 tjenere traade");
		Common lb = new Common();
		Kok kok1 = new Kok(lb, "Kok 1");
		Kok kok2 = new Kok(lb, "Kok 2");
		kok1.start();
		kok2.start();

		Tjener tj1 = new Tjener(lb, "Tjener 1");
		Tjener tj2 = new Tjener(lb, "Tjener 2");
		tj1.start();
		tj2.start();

	}

}
