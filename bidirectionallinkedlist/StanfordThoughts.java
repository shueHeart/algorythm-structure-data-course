package bidirectionallinkedlist;

import java.util.ArrayList;


public class StanfordThoughts {
	  	public Node head;
	    public Node tail;

	     public StanfordThoughts()
	     {
	       head = new Node();
	       tail = new Node();
	     }

	     public void addInTail(Node _item)
	     {
	    	 _item.next = this.tail;
	    	 this.tail.prev.next = _item;
	    	 _item.prev = this.tail.prev;
	     }

	     public Node find(int _value)
	     {
	    	 Node node = this.head.next;
	    	 
	    	 while (!node.dummy) { 
	    		 if (node.value == _value) return node;
	    	 }
	    	 
	    	 return null;
	     }

	     public ArrayList<Node> findAll(int _value)
	     {
			ArrayList<Node> nodes = new ArrayList<Node>();
			   
			Node node = this.head.next;
			   
			while (!node.dummy) {
				if (node.value == _value) nodes.add(node);
			}
			return nodes;
	     }

		public boolean remove(int _value)
		{
			Node node = this.head.next;
			
			while (!node.dummy) {
				
				if (node.value != _value) {
					node = node.next;
					continue;
				}
				
				node.next.prev = node.prev;
				node.prev = node.next;
				
				
				return true;
				
			}
			
			return false; 
		}

	     public void removeAll(int _value)
	     {
	    	 
	    	 Node node = this.head.next;
	    	 
	    	 while (!node.dummy) {
	    		 
	    		 if (node.value != _value) {
	    			 node = node.next;
	    			 continue;
	    		 }
	    		 
	    		 node.next.prev = node.prev;
	    		 node.prev = node.next;
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
			
			while (!node.dummy) {
				++count;
				node = node.next;
			}
			 
			return count; 
		}

		public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
		{
			
			_nodeToInsert.prev = _nodeAfter;			
			_nodeToInsert.next  = _nodeAfter.next;
			_nodeToInsert.next.prev = _nodeToInsert;
			_nodeAfter.next = _nodeToInsert;

			
		}
}

class Node
{
    public boolean dummy;
    public int value;
    public Node next;
    public Node prev;
    
    public Node () {
    	dummy = true;
    }
    
    public Node (int value) {
    	this.value = value;
    	dummy = false;
    }
  
}
