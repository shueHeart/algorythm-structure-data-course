
import java.util.*;

class Node<T> {
	public T value;
	public Node<T> next, prev;

	public Node(T _value) {
		value = _value;
		next = null;
		prev = null;
	}
}

public class OrderedList<T> {
	public Node<T> head, tail;
	private boolean _ascending;

	public OrderedList(boolean asc) {
		head = null;
		tail = null;
		_ascending = asc;
	}

	public int compare(T v1, T v2) {
		if (Integer.parseInt(v1.toString()) < Integer.parseInt(v2.toString())) return -1;
		if (Integer.parseInt(v1.toString()) == Integer.parseInt(v2.toString())) return 0;
		return 1;
	}

	public void add(T value) {
		Node<T> newNode = new Node<T>(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		Node<T> node = head;
		
		if (!_ascending) node = tail;
		
		while (node != null) {
			
			if (compare(newNode.value, node.value) == -1) {
				if (_ascending) {
					node.prev = newNode;
					newNode.next = node;
					head = newNode;
					return;
				}
				node.next = newNode;
				newNode.prev = node;
				tail = newNode;
				return;
			}
			
			if (compare(newNode.value, node.value) == 1 || compare(newNode.value, node.value) == 0) {
				if (_ascending) {
					newNode.next = node.next;
					node.next = newNode;
					newNode.prev = node;
					return;
				}
				newNode.next = node;
				newNode.prev = node.prev;
				node.prev = newNode;
				return;
			}
			if (_ascending) {
				node = node.next;
				continue;
			}
			node = node.prev;
		}
	}

	public Node<T> find(T val) {
		Node<T> node = head;
		while (node != null) {
			if (node.value.equals(val)) return node;
			node = node.next;
		}
		return null;
	}

	public void delete(T val) {
		Node<T> node = this.head;
		
		while (node != null) {
			
			if (!node.value.equals(val)) {
				node = node.next;
				continue;
			}
			
			if (node.next != null && node.prev != null)  {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node = node.next;
				return;
			}
			
			if (node.prev == null && node.next == null) {
				this.head = null;
				this.tail = null;
				node = node.next;
				return;
			}
			
			if (node.prev == null) {
				node.next.prev = null;
				this.head = node.next;
			}
			
			if (node.next == null) {
				node.prev.next = null;
				this.tail = node.prev;
			}
			
			return;
			
		}
		
		return; 
	}

	public void clear(boolean asc) {
		_ascending = asc;
		head = null;
		tail = null;
	}

	public int count() {
		Node<T> node = head;
		
		int count = 0;
		
		while (node != null) {
			++count;
			node = node.next;
		}
		
		return count; 
	}

	ArrayList<Node<T>> getAll()
	{
		ArrayList<Node<T>> r = new ArrayList<Node<T>>();
		Node<T> node = head;
		while (node != null) {
			r.add(node);
			node = node.next;
		}
		return r;
	}
}
