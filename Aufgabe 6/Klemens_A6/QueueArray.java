import java.util.ArrayList;

// Klemens Kurtz
public class QueueArray<E> {
	
	private ArrayList<E> queue = null;
	
	
	//default constructor for creating an empty queue
	public QueueArray (){
		queue = new ArrayList<E>();
	}
			
	
	//insert item at the end of the queue
	public void enqueue(E item) {
		queue.add(item);
	}
	
	
	//returns the head of the queue and deletes it from the queue;
	//returns null if queue is empty
	public E dequeue() {
		if(queue.isEmpty() ) 
			return null;
		else
			return queue.remove(0);
	}
	
	
	//returns the number of elements in the queue
	public int size() {
		return queue.size();
	}
	
	
	//test if queue is empty
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	
	//returns a String-representation of this queue as
	//[item1, item2, ..., itemn] with1 as the top item
	//and itemn as the last inserted item
	public String toString() {
		return queue.toString();
	}
	
	
	//returns an iterator for traversing the queue
	public MyIterator<E> getIterator(){
		MyArrayIterator<E> it = new MyArrayIterator<>();
		return it;
	}
	
	
	// Inner class Iterator:
	private class MyArrayIterator<T> implements MyIterator<E>{
		private ArrayList<E> arrIt;
		private int count;
		
		public MyArrayIterator() {
			this.arrIt = queue;
			this.count = -1;
		}
		
		//true if the iteration has more elements
		public boolean hasNext() {
			if(this.arrIt.size() == 0) return false;
			return this.count < this.arrIt.size() - 1;
		}
			
		//return the next element in the iteration - requires hasNext()!
		public E getNext() {
			if(this.hasNext() ) {
				this.count++;
				return this.arrIt.get(this.count);
			}
			else return null;
		}
	}
	
}
