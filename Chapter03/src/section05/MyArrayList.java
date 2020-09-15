package section05;

import java.util.Arrays;

public class MyArrayList<T> {

	private static final int INIT_CAPACITY = 10;
	private T data[];
	private int size;
	private int capacity;
	
	public MyArrayList() {
		this.size = 0;
		this.capacity = INIT_CAPACITY;
		this.data = (T [])new Object[INIT_CAPACITY];
	}
	
	public void add(int index, T anEntry) {
		
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		if(size >= capacity) {
			reallocation();
		}
		
		for (int i = size-1; i >= index; i--) {
			data[i+1] = data[i]; 
		}
		
		data[index] = anEntry;
		size++;
	}
	
	private void reallocation() {
		capacity = capacity * 2;
		
//		for (int i = 0; i < tmp.length; i++) {
//			tmp[i] = data[i];
//		}
		
//		System.arraycopy(data, 0, tmp, 0, tmp.length);
		
		data = Arrays.copyOf(data, capacity);
	}

	public void add(T anEntry) {
		add(size,anEntry);
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(T anEntry) {
		for (int i = 0; i < size; i++) {
			if(data[i].equals(anEntry)) {
				return i;
			}
		}
		return -1;
	}
	
	public T get(int index) {
		
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		return data[index];
	}
	
	public T set(int index,T anEntry) {
		
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		T old = data[index];
		data[index] = anEntry;
		return old;
	}
	
	public T remove(int index) {
		
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		T returnVal = data[index];
		
		for (int i = index + 1; i < size; i++) {
			data[i-1] = data[i];
		}
		
		size--;
		
		return returnVal;
	}
}
