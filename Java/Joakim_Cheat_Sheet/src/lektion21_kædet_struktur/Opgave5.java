package lektion21_kædet_struktur;

public class Opgave5 {

	public static void main(String[] args) {
		 
		var I = new NonEmptyList("Swiper", new NonEmptyList("no",
				 new NonEmptyList("swiping!", new EmptyList())));
		var II = LispList.NIL.cons("swiping!").cons("no").cons("Swiper");
		var III = LispList.NIL.array2LinkedList(new String[] { "Swiper", "no", "swiping!" });		
		
		System.out.println(I);
		System.out.println(II);
		System.out.println(III  + "\nOh man..." );
		
	}
}
