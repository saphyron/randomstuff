package lektion21_kædet_struktur;

public class EmptyList implements LispList {

	@Override
	public boolean empty() {
		return true;
	}

	@Override
	public LispList head() {
		throw new UnsupportedOperationException();
	}

	@Override
	public LispList tail() {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return "";
	}

	@Override
	public NonEmptyList cons(Object data) {
		return new NonEmptyList(data, new EmptyList());
	}

	public NonEmptyList array2LinkedList(Object[] data) {

		NonEmptyList out = null;

		for (var i = data.length - 1; i >= 0; i--) {
			if (out == null) {
				out = LispList.NIL.cons(data[i]);
				continue;
			} 
			out = out.cons(data[i]);
		}
		
		if (out == null) {
			System.out.println("impossible!");
		}
		return out;
	}
}
