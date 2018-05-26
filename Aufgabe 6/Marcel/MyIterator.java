public interface MyIterator<E> {


  //true if the iteration has more elements
  public boolean hasNext();


  //returns the next element in the interation – requires hasNext()!
  public E getNext();


}