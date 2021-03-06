package repeatsc01;

public class MySingleLinkedList<T> {

	public Node<T> head;
	public int size;
	
	public MySingleLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public void addFirst(T item) {
		Node<T> tmp = new Node<>(item);
		
		tmp.next = head;
		head = tmp;
		size++;
	}
	
	public void addAfter(Node<T> before, T item) {
		Node<T> tmp = new Node<>(item);
		
		tmp.next = before.next;
		before.next = tmp;
		size++;
	}
	
	//구현 해보기
	public void addBefore(Node<T> after,T item) {
		int index = indexOf(after.data);
		
		if(index < 0 ) {
			throw new NullPointerException();
		}
		else if(index == 0) {
			addFirst(item);
		} else {
			index = index - 1;
			Node<T> before = getNode(index);
			addAfter(before, item);
		}
	}
	
	//구현 해보기
	public void addLast(T item) {
		
		if(size == 0) {
			addFirst(item); 
		} else {
			add(size-1, item);
		}
	}
	
	public void add(int index, T item) {
		
		if(index < 0 && index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		if(index == 0) {
			addFirst(item);
		} else {
			Node<T> before = getNode(index - 1);
			addAfter(before, item);
		}
	}
	
	public void removeFirst() {
		
		if(head == null) {
			throw new NullPointerException();
		}
		
		head = head.next;
		size--;
	}
	
	public void removeAfter(Node<T> before) {
		
		if(before.next == null) {
			throw new NullPointerException();
		}
		
		before.next = before.next.next;
		size--;
	}
	
	//구현 해보기
	public void remove(T item) {
		
		int index = indexOf(item);
		
		if (index < 0) {
			throw new NullPointerException();
		}
		else if(index == 0) {
			removeFirst();
		} else {
			remove(index);
		}
		
		//방법 2
//		Node<T> p = head;
//		Node<T> q = null;
//		
//		while(p != null && !p.equals(item)){
//			q = p;
//			p = p.next;
//		}
//		
//		if(p == null) {
//			throw new NullPointerException();
//		} else if(q == null) {
//			removeFirst();
//		} else {
//			removeAfter(q);
//		}
//		
	}
	
	public void remove(int index) {
		
		if(index < 0 && index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		if(index == 0) {
			removeFirst();
		} else {
			Node<T> before = getNode(index -1);
			removeAfter(before);
		}
	}
	
	public int indexOf(T item) {
		Node<T> p = head;
		
		int index = 0;
		
		while(p != null) {
			if(p.data.equals(item)) {
				return index;
			}
			
			p = p.next;
			index++;
		}
		
		return -1;
	}
	
	public Node<T> getNode(int index) {
		
		if(index < 0 && index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		Node<T> p = head;
		
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		
		return p;
	}
	
	public T get(int index) {
		
		return getNode(index).data;
	}
}
