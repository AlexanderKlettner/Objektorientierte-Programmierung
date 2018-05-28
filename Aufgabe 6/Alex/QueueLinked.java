public class QueueLinked <E>{
   private Node<E> queue;
   
   //default constructor for creating an empty queue
   public QueueLinked (){
      this.queue = null;
   }

         
   //inserts item at the end of the queue
   public void enqueue(E item){
      Node<E> n = new Node<E>(item);
      Node <E> copy = queue;
      
      if(copy.equals(null)){
         queue = n;
      }
      while(!copy.equals(null)){
         if(copy.next.equals(null)){
            copy.next = n;
         }
         copy = copy.next;
      }
           
   }     

   //returns the head of the queue and deletes it from the queue;
   //returns null if queue is empty
   public E dequeue(){
      Node<E> copy = queue;
      queue = queue.next;      
      return copy.data;
   }


   //returns the number of elements in the queue
   public int size(){
      int i = 0;
      Node<E> copy = queue;
      while(!copy.equals(null)){
         copy = copy.next;
         i++;
      } return i;
   }


   //test if queue is empty
   public boolean isEmpty(){
      return queue.equals(null);
   }


   //returns a String-representation of this queue as
   //[item1, item2, ..., itemn] with item1 as the top item 
   //and itemn as the last inserted item
   public String toString (){
      String s = "";
      Node<E> t = queue;
      
      while(!t.equals(null)){
         if(!t.next.equals(null)){
            s=s+t.data +", ";
         } else { s=s+t.data;}
            t=t.next;
      }
      return "[" + s + "]";
   }

//    returns an iterator for traversing the queue
   public IteratorLinked<E> getIterator(){
      IteratorLinked<E> it = new IteratorLinked<E>();
      return it;
   }


   private class Node<E> {
  
      private E data;
      private Node<E> next;
  
      public Node (E d) {
         data = d;
         next = null;
      }
   }
   
   private class IteratorLinked<T> implements MyIterator{
      private Node<E> head;
      
      IteratorLinked(){
         this.head = queue;
      }
      
      public boolean hasNext() {
			return this.head != null;
		}
		
		public E getNext() {
			E dat = null;
			if(this.hasNext()) {
				dat = this.head.data;
				this.head = this.head.next;
			}
			return dat;
			
		}
   }  
}