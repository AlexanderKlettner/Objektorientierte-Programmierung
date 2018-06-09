// Klemens Kurtz
public interface MyIterator<E> {

	//true if the iteration has more elements
	public boolean hasNext();
	
	
	//return the next element in the iteration - requires hasNext()!
	public E getNext();
	
}
