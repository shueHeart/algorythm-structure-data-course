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
        		node = node.next;
        		prev = node;
        		continue;
        	}
        	
        	if (prev == null) {
        		this.head = node.next;
        		continue;
        	}
        	
        	if (node.next != null) {
        		prev.next = node.next;
        	}
        	
        	if (node.next == null) {
        		prev.next = null;
        		this.tail = node;
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
        if(_nodeAfter != null) {
            if(this.head != null) {
                Node node = this.head;
            
                while (node != null) {
                    if (node.equals(_nodeAfter)) {
                        if(node.next != null){
                            _nodeToInsert.next = node.next;
                            node.next = _nodeToInsert;
                            break;
                        }else{
                            node.next = _nodeToInsert;
                            this.tail = _nodeToInsert;
                            break;
                        }
                    }
                }
            }else 
                this.head = _nodeToInsert;
        }else{
            if(this.head != null) {
                _nodeToInsert.next = this.head;
                this.head = _nodeToInsert.next;
            }else
                this.head = _nodeToInsert;
        }

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
