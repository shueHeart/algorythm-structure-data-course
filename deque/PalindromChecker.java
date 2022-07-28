package deque;

import java.util.*;

public class PalindromChecker {

	public static boolean isPalindrom (String str) {
		
		Deque deque = new Deque();
		
		for (int i = 0; i < str.length(); ++i) {
			deque.addFront(str.charAt(i));
		}
		
		while (deque.size() != 0) {
			
			Object fromFront = deque.removeFront();
			Object fromTail = deque.removeTail();
			
			if (!fromFront.equals(fromTail) && fromTail != null) {
				return false;
			}
		}
		
		return true;
		
	}

}


