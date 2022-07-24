package stack;

import java.util.*;

public class ReversedStack<T> {

	List<T> stack;

	public ReversedStack() {
		stack = new ArrayList<T>();
	}

	public int size() {
		return stack.size();
	}

	public T pop() {
		if (stack.size() == 0)
			return null;

		return stack.remove(0);
	}

	public void push(T val) {
		stack.add(val);
	}

	public T peek() {
		if (stack.size() == 0)
			return null;
		return stack.get(0);
	}
}
