package queue;

import java.util.ArrayList;
import java.util.List;

public class QueueTwister {
	public static void twist (Queue queue, int N) {
		
		if (queue.size() == 0) return;
		
		int realTwist = N % queue.size();
				
		Queue tail = new Queue();
		Queue head = new Queue();
		
		for (int i = 0; i < realTwist; ++i) {
			tail.enqueue(queue.dequeue());
		}
		
		int size = queue.size();
		for (int i = 0; i < size; ++i) {
			head.enqueue(queue.dequeue());
		}
		
		size = head.size();
		for (int i = 0; i < size; ++i) {
			queue.enqueue(head.dequeue());
		}
		
		size = tail.size();
		for (int i = 0; i < size; ++i) {
			
			queue.enqueue(tail.dequeue());
		}
		
	}
	
	public static Stack doubleStackQueue (List elements) {
		
		Stack firstStack = new Stack();
		
		for (int i = 0; i < elements.size(); ++i) {
			firstStack.push(elements.get(i));
		}
		
		Stack secondStack = new Stack();
		
		while (firstStack.size() != 0) {
			secondStack.push(firstStack.pop());
		}
		
		return secondStack;
	}
}

class Stack<T> {

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
