package deque;

import java.util.*;

public class PalindromChecker {

	public static boolean isPalindrom (Deque deque) {
		
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
