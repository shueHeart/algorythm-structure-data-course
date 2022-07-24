package queue;

import java.util.*;

public class Queue<T> {
	
	private List<T> storage;
	
	public Queue() {
		storage = new ArrayList<T>();
	}

	public void enqueue(T item) {
		storage.add(item);
	}

	public T dequeue() {
		
		if (storage.size() == 0) return null;
		
		return storage.remove(0);
		
	}

	public int size() {
		return storage.size(); 
	}

}
