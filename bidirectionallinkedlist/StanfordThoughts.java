
import java.util.ArrayList;


public class StanfordThoughts {
	private Node head;
	private Node tail;

	public StanfordThoughts()
	{
		head = new DummyNode(0);
		tail = new DummyNode(0);
		   
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
		
	public void addInTail(Node _item)
	{			 
		_item.next = this.tail;
		this.tail.prev.next = _item;
		_item.prev = this.tail.prev;
		this.tail.prev = _item;
	}
		
	public Node find(int _value)
	{
		Node node = this.head.next;

		while (!node.getClass().equals(DummyNode.class)) { 
			if (node.value == _value) return node;
			node = node.next;
		}

		return null;
	}

	public ArrayList<Node> findAll(int _value)
	{
		ArrayList<Node> nodes = new ArrayList<Node>();
	
		Node node = this.head.next;

		while (!node.getClass().equals(DummyNode.class)) {
			if (node.value == _value) nodes.add(node);
			node = node.next;
		}
		return nodes;
	}

	public boolean remove(int _value)
	{
		Node node = this.head.next;

		while (!node.getClass().equals(DummyNode.class)) {

			if (node.value != _value) {
				node = node.next;
				continue;
			}

			node.next.prev = node.prev;
			node.prev.next = node.next;

			return true;

		}	

		return false; 
	}

	public void removeAll(int _value)
	{

		Node node = this.head.next;

		while (!node.getClass().equals(DummyNode.class)) {

			if (node.value != _value) {
			node = node.next;
			continue;
			}

			node.next.prev = node.prev;
			node.prev.next = node.next;

			node = node.next;
		}


	}

	public void clear()
	{
		this.head.next = null;
		this.tail.prev = null;
	}

	public int count()
	{
		int count = 0;

		Node node = this.head.next;

		while (!node.getClass().equals(DummyNode.class)) {
			++count;
			node = node.next;
		}

		return count; 
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
	{
		if (_nodeAfter == null) {
			this.head.next.prev = _nodeToInsert;
			_nodeToInsert.next = this.head.next;
			this.head.next = _nodeToInsert;
			_nodeToInsert.prev = this.head;
			return;
		}

		_nodeToInsert.prev = _nodeAfter;			
		_nodeToInsert.next  = _nodeAfter.next;
		_nodeToInsert.next.prev = _nodeToInsert;
		_nodeAfter.next = _nodeToInsert;
	}
}

public class Node
{
	public int value;
	public Node next;
	public Node prev;

	public Node (int value) {
		this.value = value;
	}	
}

public class DummyNode extends Node
{
	public DummyNode (int value) {
		super(value);
	}
}


