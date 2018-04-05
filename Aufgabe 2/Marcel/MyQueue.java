import java.util.*;


public class MyQueue<T> {
	
	private List<T> queue; // just Declaration, no initialization
//	private final Class<T> type;
	
	//constructor, creats an empty queue
	public MyQueue() {
		this.queue = new ArrayList<T>();
//		this.type = type;
	}
	
//	public Class <T> getType() {
//		return this.type;
//	}
//	
	
	
	//inserts item at the end of this queue
	public void enqueue (T item) {
		queue.add(item); //adds to the end
	}
	
	
	//returns the first item of this queue and deletes it
	public T dequeue () {
		T item = queue.get(0);
		queue.remove(0);
		//Can the two above be done in one line?
		
		return item;
	}
	
	//returns the first item of this queue without deleting
	public T peek () {
		return queue.get(0);
	}
	
	//peeks at given location
	public T peekAt(int location) {
		return queue.get(location);
	}
	//returns true if this queue contains no elements
	public boolean isEmpty() {
		return queue.size() == 0;
	}
	
	//returns the number of elements in this queue
	public int size () {
		return queue.size();
	}
	

	public String toString() {
		String listString = "Remainder of Queue:\n";

		for (T item : queue)
		{
		    listString += item + "\n";
		}
		
		return listString;
	}
	
	


	
}
