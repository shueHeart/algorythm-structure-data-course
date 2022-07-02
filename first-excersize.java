import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
    	
        if (this.head == null) {
            this.head = item;
        }
        else {
        	this.tail.next = item;
        }
            
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        if(node != null && node.value == _value){      
            this.head = node.next;          
            return true;
        }
        while (node != null) {
        	
            if (node.next == null) return false;
            
            if (node.next.value != _value) {
            	node = node.next;
            	continue;
            }
            
            if (node.next.next != null) node.next = node.next.next;
            
            if (node.next.next == null) {
            	node.next = null;
            	this.tail = node;
            }
            
            node = node.next;
            
            return true;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        
    	Node node = this.head;
    	Node prev = null;
    	
        while (node != null) {
        	
        	if (node.value != _value) {
        		prev = node;
        		node = node.next;
        		continue;
        	}
        	
        	if (prev == null) {
        		this.head = node.next;
            	node = node.next;
        		continue;
        	}
        	
        	if (node.next != null) {
        		prev.next = node.next;
        	}
        	
        	if (node.next == null) {
        		prev.next = null;
        		this.tail = prev;
        	}
        	
        	node = node.next;

        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while(node != null) {
            ++count;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
    	 
    	if (_nodeAfter == null) {
    		_nodeToInsert.next = this.head;
    		this.head = _nodeToInsert;
    		return;
    	}
    	
    	if (_nodeAfter.next != null) this.tail = _nodeToInsert;
    	
    	_nodeToInsert.next = _nodeAfter.next;
    	_nodeAfter.next = _nodeToInsert;
    }
    
    public LinkedList concat(LinkedList l1, LinkedList l2) {
    	
    	if (l1.count() != l2.count()) return null;
    	
    	LinkedList concated = new LinkedList();
    	
    	Node nodeFromFirst = l1.head;
    	Node nodeFromSecond = l2.head;
    	    	
    	while (nodeFromFirst != null && nodeFromSecond != null) {
    		
    		concated.addInTail(new Node(nodeFromFirst.value + nodeFromSecond.value));
    		
    		nodeFromFirst = nodeFromFirst.next;
    		nodeFromSecond = nodeFromSecond.next;
    		
    	}
    	
    	return concated;
    	
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
