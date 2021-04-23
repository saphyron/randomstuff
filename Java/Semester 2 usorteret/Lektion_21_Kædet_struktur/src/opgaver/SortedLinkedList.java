package opgaver;
import java.util.LinkedList;
import java.util.ListIterator;

public class SortedLinkedList {
	
	private LinkedList<String> list = new LinkedList<>();
	private Node first;
	
	private class Node {
		public Object data;
		public Node next;
		
	}

public SortedLinkedList() {
	first = null;
	}
	/**
	* Tilføjer et element til listen, så listen fortsat er sorteret i
	* henhold til den naturlige ordning på elementerne.
	* @param element det der indsættes
	*/
	public void addElement(String element) {
		if (first == null) {
			list.addFirst(element);
		} else if (element.compareTo(first.data) <= 0) {
			this.first = new Node(element, first);
		}
	}
	/**
	* Fjerner et element fra listen.
	* @param element det element der fjernes
	* @return true hvis elementet blev fjernet, men ellers false.
	*/
	public boolean removeElement(String element) {
	
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
//	@Override
//	public String toString() {
//	// TODO: lav mig, så jeg returnerer indholdet som en pæn String
//	}
}