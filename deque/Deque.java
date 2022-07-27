package deque;

import java.util.*;

public class Deque<T> {

	private List<T> storage;

	public Deque() {
		storage = new ArrayList<T>();
	}

	public void addFront(T item) {
		storage.add(0, item);
	}

	public void addTail(T item) {
		storage.add(item);
	}

	public T removeFront() {
		if (storage.size() == 0) return null;
		return storage.remove(0);
	}

	public T removeTail() {
		if (storage.size() == 0) return null;
		return storage.remove(storage.size() - 1);	
	}

	public int size() {
		return storage.size();
	}

}
