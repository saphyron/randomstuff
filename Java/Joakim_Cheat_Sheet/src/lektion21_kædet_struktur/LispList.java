package lektion21_kædet_struktur;

public interface LispList {
	public boolean empty();
	public LispList head();
	public LispList tail();
	public static final EmptyList NIL = new EmptyList();
	public NonEmptyList cons(Object data);
}