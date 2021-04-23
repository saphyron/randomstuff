package soegningelevopgaver;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5 og 6
		//Opgave 2
		int[] talIntervalArray = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println("Hvis tallet der returners er mellem 10-15 s� er opgaven klaret: " + s.findInterval(talIntervalArray));
		//Opgave 3
		int[] talEns1Array = {7,9,13,7,9,13};
		System.out.println("Er der et ens tal i talArray ? " + s.findToEns(talEns1Array));
		int[] talEns2Array = {7,9,13,13,9,7};
		System.out.println("Er der et ens tal i talArray ? " + s.findToEns(talEns2Array));
		//Opgave 6

	}

}
