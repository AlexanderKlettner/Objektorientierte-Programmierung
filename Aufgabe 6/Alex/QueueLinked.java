public class QueueLinked <E>{
   private Node<E> head;
   private Node<E> tail;
   
   //default constructor for creating an empty queue
   public QueueLinked (){
      this.head = null;
      this.tail = null;
   }
      
   //inserts item at the end of the queue
   public void enqueue(E item){
      Node<E> n = new Node<E>(item);
      if(this.size() != 0){
         this.tail.next = n;
         this.tail = n;
      }else { this.head = this.tail = n;}     
   }     

   //returns the head of the queue and deletes it from the queue;
   //returns null if queue is empty
   public E dequeue(){
      if(this.size() != 0){
         Node<E> copy = head;
         this.head = this.head.next;
         copy.next = null;
               
         return copy.data;
      }else{return null;}
   }


   //returns the number of elements in the queue
   public int size(){
      int i = 0;
      Node<E> copy = head;
      while(copy != null){
         copy = copy.next;
         i++;
      } return i;
   }


   //test if queue is empty
   public boolean isEmpty(){
      return head == null;
   }


   //returns a String-representation of this queue as
   //[item1, item2, ..., itemn] with item1 as the top item 
   //and itemn as the last inserted item
   public String toString (){
      String s = "";
      Node<E> t = this.head;
      
      while(t != null){
         if(t.next != null){
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


   public class Node<E> {
  
      public E data;
      public Node<E> next;
  
      public Node (E d) {
         data = d;
         next = null;
      }
      public int size(){
         int s = 0;
         while(this.next != null){
            this.next = this.next.next;
            s++;
         } return s;
      }
      public Node<E> get(int i){
         Node<E> ret = this.get(1);
         if(i<this.size()){
         for(int j = 1; j<=i; j++){
            ret=this.next;
         } return ret;
         }else return null;
      }
   }
   
   private class IteratorLinked<T> implements MyIterator{
      private Node<E> h;
      int counter;
      
      IteratorLinked(){
         this.h = head;
         this.counter = -1;
      }
      
      public boolean hasNext() {
			return this.counter < this.h.size() - 1;
		}
		
		public E getNext() {	
			if(this.hasNext()) {
            counter++;
				return h.get(counter).data;
			}else return null;		
		}
   }  
}
