
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
	public int contains(E item) {

		// Look at head, and check
		Node<E> p = this.head;
		Node<E> prev = null;
		int i = 1; // Counter, which pointer is being looked at currently

		if (p == null)
			return -1; // Stack is empty

		while (p != null && !p.data.equals(item)) {
			// p != null: pointer does not point to null (meaning, its not the last element
			// in the structure)
			// p.data != item: Keep searching until item has been found
			prev = p; // set previous to location to that of current pointer
			p = p.next; // increment pointer p
			i++; // Increment counter for position retrieval
		}

		if (p.data.equals(item)) {
			// Item has been found
			return i;
		} else
			return -1;
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
