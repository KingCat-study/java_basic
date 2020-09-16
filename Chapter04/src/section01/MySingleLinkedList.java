package section01;

public class MySingleLinkedList<T> {
	
	public Node<T> head;
	public int size;

	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(T item) {
		Node<T> newHead =  new Node<T>(item); //T : type parameter
		
		newHead.next = head;
		head = newHead;
		size++;
	}
	
	public void addAfter(Node<T> before, T item) {
		Node<T> tmp =  new Node<T>(item); //T : type parameter
		tmp.next = before.next;
		
		before.next = tmp;
		size++;
	}
	
	public void addBefore(Node<T> after, T item) {
		Node<T> tmp =  new Node<T>(item); //T : type parameter
		
		tmp.next = after;
		
		int index = indexOf(after.data);
		
		if(index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else if(index == 0){
			addFirst(item);
		} else {
			index = index - 1; 
			Node<T> before = getNode(index);
			
			before.next = tmp;
			size++;
		}
	}
	
	//노드 생성 후 추가
	public void add(int index, T item) {
		
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		if(index == 0) {
			addFirst(item);
		} else {
			Node<T> tmp = getNode(index -1);
			addAfter(tmp , item);
		}
	}
	
	//생성 된 노드 삭제
	public void remove(int index) {
		
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		if(index == 0) {
			removeFirst();
		} else {
			Node<T> prev = getNode(index -1);
			removeAfter(prev);
		}
	}
	
	public void remove(T item) {
		Node<T> p = head;
		Node<T> q = null;
		
		while(p != null && !p.equals(item)) {
			q = p;
			p = p.next;
		}
		
		if(p == null) {
			return;
		} else if (q == null) {
			removeFirst();
		} else {
			removeAfter(q);
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
	
	//검색
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
		
		if(index < 0 || index >= size) {
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
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		list.addFirst("Monday");
		list.addFirst("Sunday");
		list.add(2, "Saturday");
		list.add(2, "Friday");
		list.remove("Friday");
		int index = list.indexOf("Saturday");
		System.out.println(index);
	}
}
