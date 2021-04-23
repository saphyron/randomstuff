package bagopgave;import java.util.ArrayList;import java.util.Arrays;import java.util.Collection;import java.util.NoSuchElementException;public class ArrayBag<T> implements Bag<T> {	private T[] e = (T[]) new Object[22];	private int currentSize;	@Override	public int getCurrentSize() {		return currentSize;	}	@Override	public boolean isFull() {		if (getCurrentSize() == 22) {			return true;		}		return false;	}	@Override	public boolean isEmpty() {		if (currentSize == 0) {			return true;		}		return false;	}	@Override	public boolean add(T newEntry) {		if (isFull()) {			return false;		} else {			e[getCurrentSize()] = newEntry;			currentSize++;			return true;		}	}	@Override	public T remove() {		if (getCurrentSize() == 0) {			throw new NoSuchElementException("Fejl! Array er Tom.");		}		T result = e[getCurrentSize() - 1];		currentSize--;		return result;	}	@Override	public boolean remove(T anEntry) {		if (getCurrentSize() == 0) {			throw new NoSuchElementException("Fejl! Array er Tom.");		}		if (contains(anEntry)) {			for (int i = 0; i < getCurrentSize(); i++) {				if (e[i] != null && e[i].equals(anEntry)) {					ArrayList<T> a = new ArrayList(Arrays.asList(e));					a.remove(i);					e = (T[]) new String[22];					a.toArray(e);					currentSize--;				}			}			return true;		}		return false;	}	@Override	public void clear() {		if (!isEmpty()) {			while (!isEmpty()) {				remove();			}		}	}	@Override	public int getFrequencyOf(T anEntry) {		int amount = 0;		if (getCurrentSize() == 0) {			throw new NoSuchElementException("Fejl! Array er Tom.");		}		if (contains(anEntry)) {			for (int i = 0; i < getCurrentSize(); i++) {				if (e[i] != null && e[i].equals(anEntry)) {					amount++;				}			}		}		return amount;	}	@Override	public boolean contains(T anEntry) {		if (getCurrentSize() == 0) {			throw new NoSuchElementException("Fejl! Array er Tom.");		}		for (int i = 0; i < getCurrentSize(); i++) {			if (e[i] != null && e[i].equals(anEntry)) {				return true;			}		}		return false;	}	@Override	public T[] toArray() {		if (getCurrentSize() == 0) {			throw new NoSuchElementException("Fejl! Array er Tom.");		}		ArrayList<T> a = new ArrayList(Arrays.asList(e));		e = (T[]) new String[getCurrentSize()];		a.toArray(e);		return e;	}}