import java.util.ArrayList;

public class QueueArray<E> {
	
	//Instance variables
	private ArrayList<E> queue = null;
	
	//default constructor for creating an empty queue
	public QueueArray () {
		this.queue = new ArrayList<E>();
	}

//	//inserts item at the end of the queue
	public void enqueue(E item) {
		this.queue.add(item);
	}
	
	
	public E peek() {
		return this.queue.get(0);
	}
//
//
//	//returns the head of the queue and deletes it from the queue;
//	//returns null if queue is empty
	public E dequeue() {
		if(this.size() != 0) {
			//Take first element in ArrayList
			return this.queue.remove(0); 
		}else return null;
	}
//
//
//	//returns the number of elements in the queue
	public int size() {
		return this.queue.size();
	}
//
//
//	//test if queue is empty
	public boolean isEmpty() {
		return this.size() == 0;
	}
//
//
//	//returns a String-representation of this queue as
//	//[item1, item2, ..., itemn] with item1 as the top item 
//	//and itemn as the last inserted item
	public String toString () {
		return this.queue.toString();
	}
//
	private class myALIterator<T> implements MyIterator <E>{
		
		private ArrayList<E> AL;
		private int counter;
		
		public myALIterator() {
			this.AL = queue;
			this.counter = -1; //so one incrementation gives us the element at position 0 (so first one in ArrayLst)
		}
		
		public boolean hasNext() {
			if(this.AL.size() == 0)return false; //Empty ArrayList
			
			
			return this.counter < this.AL.size() - 1;
		}
		
		public E getNext() {
			if(this.hasNext()) {
				this.counter++;
				return this.AL.get(this.counter);
			}else return null;
		}
	}
//	//returns an iterator for traversing the queue
	public MyIterator<E> getIterator(){
		myALIterator<E> it = new myALIterator<>();
		return it;
	}
}
