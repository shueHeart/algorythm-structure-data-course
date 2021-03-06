
import java.util.*;

public class DynArray<T> {
	public T[] array;
	public int count;
	public int capacity;
	Class clazz;

	public DynArray(Class clz) {
		clazz = clz;
		count = 0;
		makeArray(16);
	}

	public void makeArray(int new_capacity) {
		
		if (new_capacity < 16) new_capacity = 16;
	
		T[] forCopy = array;
		array = (T[]) Array.newInstance(this.clazz, new_capacity);
		capacity = new_capacity;
		
		if (array == null) return; 
		
		for (int i = 0; i < count; ++i) {
			array[i] = forCopy[i]; 
		}

	}

	public T getItem(int index) {
		if (index < 0 || index > count - 1) throw new RuntimeException("Index was out of range");

		return array[index];
	}

	public void append(T itm) {
		if (count == capacity) makeArray(capacity * 2);

		array[count] = itm;
		++count;
	}

	public void insert(T itm, int index) {
		if (index < 0 || index > count) {
			throw new RuntimeException("Index was out of range");
		}
		
		if (count + 1 > capacity) {
			makeArray(capacity * 2);
		}
		
		T[] copy = Arrays.copyOfRange(array, index, count);
		
		array[index] = itm;

		++count;
		for (int i = index + 1; i < count; ++i) {
			array[i] = copy[i - (index + 1)];
		}
		

	}

	public void remove(int index) {

		if (index < 0 || index > count - 1) {
			throw new RuntimeException("Index was out of range");
		}
		
		if (count == 1) {
			array[0] = null;
			--count;
			makeArray(0);
			return;
		}
		
		T[] copy = Arrays.copyOfRange(array, index + 1, count);
		
		array[count - 1] = null;
		
		--count;
		for (int i = index; i < count; ++i) {
			array[i] = copy[i - index];				
		}

		int squeez = capacity - (capacity / 2 + 1);
		

		if (count == squeez) {
			int newcap = capacity * 2 / 3;
			makeArray(newcap);
		}
	}

}
