// Klemens Kurtz

public class QueueLinked<E>{
	private Node<E> head;
	private Node<E> tail;
	
	//default constructor for creating an empty queue
	public QueueLinked (){ 
		head = null;
		tail = null;
	}
			
	
	//insert item at the end of the queue
	public void enqueue(E item) {	
		Node<E> p = new Node<E>(item);
		if(this.size() == 0) {
			this.tail = p;
			this.head = p;
		}			
		else {
			this.tail.next = p;
			tail = p;
		}
		//head = p;
	}
	
	
	//returns the head of the queue and deletes it from the queue;
	//returns null if queue is empty
	public E dequeue() {
		if(size() == 0) return null;
		else {
			Node<E> prev = head;
			head = head.next;
			return prev.data;
		}
	}
	
	
	//returns the number of elements in the queue
	public int size() {
		Node<E> p = head;
		int size = 0;
		while(p != null) {
			p = p.next;
			size++;
		}		
		return size;
	}
	
	
	//test if queue is empty
	public boolean isEmpty() {
		return size() == 0;
	}
	
	
	//returns a String-representation of this queue as
	//[item1, item2, ..., itemn] with1 as the top item
	//and itemn as the last inserted item
	public String toString() {
		String string = "";
		Node<E> p = head;
		while(p != null) {
			if(p.next != null) {
				string = string + p.data + ", ";
			}
			else {
				string = string + p.data;
			}
			p = p.next;
		}
		return "[" + string + "]";
	}
	
	
	//returns an iterator for traversing the queue
	public MyIterator<E> getIterator(){
		MyDynIterator<E> it = new MyDynIterator<>();
		return it;
	}
	
	
	private class MyDynIterator<T> implements MyIterator<E>{
	
		private Node<E> p;
		
		private MyDynIterator(){
			this.p = head;
		}
		
		//true if the iteration has more elements
		public boolean hasNext() {
			return this.p != null;			
		}
	
	
		//return the next element in the iteration - requires hasNext()!
		public E getNext() {
			E dat = null;
			if(this.hasNext() ) {
				dat = this.p.data;
				this.p = this.p.next;
			}
			return dat;
		}
	}
	
	// Inner class Node for Queue
	private class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T d) {
			data = d;
			next = null;
		}
	}
	
}
