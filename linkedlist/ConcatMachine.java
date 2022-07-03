package linkedlist;

public class ConcatMachine {

	public static LinkedList concat(LinkedList l1, LinkedList l2) {
	
	LinkedList concated = new LinkedList();		
		
    	if (l1.count() != l2.count()) return new LinkedList();

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
