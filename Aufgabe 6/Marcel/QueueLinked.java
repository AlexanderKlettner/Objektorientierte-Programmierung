
public class QueueLinked<E>{

	// Realize Queue with dynamic structure:

	private Node<E> head;
	private Node<E> tail;

	// default constructor for creating an empty queue
	public QueueLinked() {
		this.head = null;
		this.tail = null;
	}

	// inserts item at the end of the queue
	public void enqueue(E item) {
		Node<E> p = new Node<>(item);
		if (this.size() == 0) {
			this.tail = this.head = p;
		} else {
			this.tail.next = p; // old last one points to new last one
			this.tail = p; // set new last one
		}
	}

	// //returns the head of the queue and deletes it from the queue;
	// //returns null if queue is empty
	public E dequeue() {
		// Get current head:
		Node<E> helper = this.head;

		// Change head
		this.head = this.head.next;

		return helper.data;

	}

	// //returns the number of elements in the queue
	public int size() {
		Node<E> helper = this.head;
		int counter = 0;
		while (helper != null) {
			helper = helper.next;
			counter++;
		}
		return counter;
	}

	// //test if queue is empty
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// //returns a String-representation of this queue as
	// //[item1, item2, ..., itemn] with item1 as the top item
	// //and itemn as the last inserted item
	public String toString() {
		String result = "[";

		// "Loop over all the pointers"

		Node<E> p = head;
		if (p == null) {
			return "Empty Stack";
		}

		while (p != null) {

			if (p.next != null) {
				result = result + p.data + ", ";
			} else {
				// last data point, does not get "," afterwards
				result = result + p.data;
			}
			p = p.next;

		}

		return result + "]";
	}
	

	//returns an iterator for traversing the queue
//	public MyIterator<E> getIterator()
	// Node Class
	private class Node<T> {

		T data;
		Node<T> next;

		public Node(T d) {
			data = d;
			next = null;
		}
	}

	
	private class myDynIterator<T> implements MyIterator <T>{
		
		private Node<E> h;
		
		myDynIterator(){
			this.h = head;
		}
		
		public boolean hasNext() {
			return this.h != null;
		}
		
		public T getNext() {
			T dat = null;
			if(this.hasNext()) {
				dat = (T) this.h.data;
				this.h = this.h.next;
			}
			return dat;
			
		}
		
		
	}
	// MyIterator class:
	public MyIterator<E> getIterator(){
		myDynIterator<E> it = new myDynIterator<>();
		return it;
	}
}