package deque;

public class PalindromChecker {

	public static boolean isPalindrom (Deque deque) {
		
		while (deque.removeFront().equals(deque.removeTail())) {}
		
		if (deque.size() == 0) return true;
		
		return false;
		
	}

}
