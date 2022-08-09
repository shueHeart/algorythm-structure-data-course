package hashtable;

import java.util.*;

public class HashTable {
	public int size;
	public int step;
	public String[] slots;

	public HashTable(int sz, int stp) {
		size = sz;
		step = stp;
		slots = new String[size];
		for (int i = 0; i < size; i++)
			slots[i] = null;
	}

	public int hashFun(String value) {
		byte[] arr = value.getBytes();

		int sum = 0;

		for (int i = 0; i < arr.length; ++i) {
			sum += arr[i];
		}

		return sum % size;

	}

	public int seekSlot(String value) {
		
		int index = hashFun(value);

		if (slots[index] == null)
			return index;

		int collisionIndex = index + step;
		boolean circle = false;
		if (collisionIndex >= size) {
			circle = true;
			collisionIndex = 0;
		}
		while (true) {

			if (slots[collisionIndex] == null)
				return collisionIndex;

			collisionIndex += step;

			if (circle && collisionIndex > index) return -1;

			if (collisionIndex >= size) {
				collisionIndex = 0;
				circle = true;
			}

		}
		
	}

	public int put(String value) {
		
		int index = seekSlot(value);
		
		if (index == -1) return -1;
		
		slots[index] = value;
		
		return index;
		
	}

	public int find(String value) {
		int index = hashFun(value);
		
		if (slots[index] == null) return -1;
		
		if (slots[index].equals(value)) return index;
		
		return -1;
		
	}
}