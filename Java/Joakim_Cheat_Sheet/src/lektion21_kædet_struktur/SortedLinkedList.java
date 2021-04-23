package lektion21_kædet_struktur;

// skrevet af Thor
import java.util.NoSuchElementException;

public class SortedLinkedList {

	private Node first;

	private class Node {
		public String data;
		public Node next;

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public SortedLinkedList() {
		first = null;
	}

	/**
	 * Tilføjer et element til listen, så listen fortsat er sorteret i henhold til
	 * den naturlige ordning på elementerne.
	 * 
	 * @param element det der indsættes
	 */
	public void addElement(String element) {

		if (first == null) {
			first = new Node(element, null);
		} else if (element.compareTo(first.data) <= 0) {
			this.first = new Node(element, first);
		} else {
			Node position = first;
			while (position.next != null && position.next.data.compareTo(element) <= 0) {
				position = position.next;
			}

			position.next = new Node(element, position.next);
		}
	}

	/**
	 * Fjerner et element fra listen.
	 * 
	 * @param element det element der fjernes
	 * @return true hvis elementet blev fjernet, men ellers false.
	 */
	public boolean removeElement(String element) {

		Node position = first;
		Node previous = null;
		
		while (position != null) {
			previous = position;
			position = position.next;

			if (position.data.equals(element)) {
				previous.next = position.next;
				position.next = null;

				return true;
			}
		}
		return false;
	}

	/**
	 * Returnerer antallet af elementer i listen.
	 */
	public int countElements() {

		int counter = 0;
		Node position = first;

		while (position != null) {
			counter++;
			position = position.next;
		}

		return counter;
	}

	/**
	 * OPGAVE 3 
	 * Tilføjer alle elementerne fra list til den aktuelle liste. 
	 * Listen er fortsat sorteret i henhold til den naturlige ordning på elementerne.
	 */
	public void addAll(SortedLinkedList list) {
		Node listPos = list.first;
		while (listPos != null) {
			addElement(listPos.data);
			listPos = listPos.next;
		}
	}
	
	/**
	 * OPGAVE 4
	 * @return the number of elements in list counted recursively
	 */
	public int countElementsrecursively() {
		return countElementsRecursivelyHelper(first);
	}
	
	private int countElementsRecursivelyHelper(Node currentNode) {
		if(currentNode == null) {
			return 0;
		}
		return countElementsRecursivelyHelper(currentNode.next) + 1;
	}

	@Override
	public String toString() {
		if (first == null) {
			throw new NoSuchElementException("Listen indeholder ingen objekter");
		}

		String toString = "";
		Node position = first;

		while (position.next != null) {
			toString += position.data + ", ";
			position = position.next;
		}

		toString += position.data;

		return toString;
	}
}