
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
		
		if (new_capacity < 16) return;
	
		T[] forCopy = array;
		array = (T[]) Array.newInstance(this.clazz, new_capacity);
		capacity = new_capacity;
		
		if (array == null) return; 
		
		for (int i = 0; i < count; ++i) {
			array[i] = forCopy[i]; 
		}

		capacity = new_capacity;
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

		for (int i = index + 1; i < count + 1; ++i) {
			array[i] = copy[i - (index + 1)];
		}
		++count;

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
		
		for (int i = index; i < count - 1 ; ++i) {
			array[i] = copy[i - index];				
		}
		--count;

		float squeez = capacity / count;

		if (squeez <= 1.5) {
			int newcap = capacity / count;
			makeArray(newcap);
		}
	}

}
