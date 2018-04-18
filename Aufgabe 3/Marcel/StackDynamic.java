// Marcel Steger
public class StackDynamic<E> {

	private Node<E> head;
	// private E data;

	// typical stack methos

	// constructor, creats an empty stack
	public StackDynamic() {
		this.head = null;
	}

	// inserts item at the top of this stack
	public void push(E item) {
		Node<E> p = new Node<>(item);
		p.next = this.head;
		this.head = p;
	}

	// returns the top item of this stack and removes it
	public E pop() {
		Node<E> p = head; // get top element
		head = p.next; // set top element to null
		return p.data; // return data of top element

	}

	// returns the top item of this stack without removing it
	public E peek() {
		return this.head.data; // Does the as pop, without redirecting pointers
	}

	// returns true if this stack contains no elements
	public boolean isEmpty() {
		return head == null;
	}

	// additional useful methods

	// returns the position of item on this stack, the top positon has
	// count 1, returns -1 if item is not on this stack;
	// compares items with equals!
	public int contains (E d) {
		 Node<E> p = head;
		 int i = 0;
		 while (p != null && p.data.equals(d)) {
			 p = p.next;
		 	 i++;
		 }
		 if(p != null) return i;
		 else return -1;
		}

	// returns a String-representation of this stack as
	// [item1, item2, ...] with item1 as the top item
	public String toString()

	{
		String result = "[";

		// "Loop over all the poiinters"

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

	public int getSize() {
		if (this.isEmpty())
			return 0;

		Node<E> p = head;
		int size = 0;
		while (p != null) {
			size++;
			p = p.next;
		}
		return size;
	}

	private class Node<T> {

		T data;
		Node<T> next;

		public Node(T d) {
			data = d;
			next = null;
		}
	}

}
