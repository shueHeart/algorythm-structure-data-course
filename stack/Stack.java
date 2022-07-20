package stack;

import java.util.*;

public class Stack<T> {

	public List<T> stack;
	
	public Stack() {
		stack = new ArrayList<T>();
	}

	public int size() {
		return stack.size();
	}

	public T pop() {
		if (stack.size() == 0) return null;
		
		return stack.remove(stack.size() - 1);
	}

	public void push(T val) {
		stack.add(val);
	}

	public T peek() {
		if (stack.size() == 0) return null; 
		return stack.get(stack.size() - 1);
	}
}