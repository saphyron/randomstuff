package lektion21_kædet_struktur;

public class NonEmptyList implements LispList {
	
	private Object data;
	private LispList head;
	private LispList tail;
	
	public NonEmptyList(Object data, LispList tail) {
		this.data = data;
		this.tail = tail;
		if (tail instanceof NonEmptyList) {
			NonEmptyList nonEmptyList = (NonEmptyList) tail;
			nonEmptyList.setHead(this);
		}
	}
	
	@Override
	public boolean empty() {
		return false;
	}

	@Override
	public LispList head() {
		return head;
	}

	@Override
	public LispList tail() {
		return tail;
	}
	
	public Object getData() {
		return data;
	}
	
	public String toString() {
		return data + " " + tail().toString(); 
	}
	
	public void setHead(LispList head) {
		this.head = head;
	}

	@Override
	public NonEmptyList cons(Object data) {
		return new NonEmptyList(data, this);
	}
}