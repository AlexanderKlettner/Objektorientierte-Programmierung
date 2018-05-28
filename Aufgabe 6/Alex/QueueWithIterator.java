public class QueueWithIterator{
   public static void main(String[] args){
   
       QueueArray<Integer> IntQueueArr = new QueueArray <Integer>();
       
       //filling the queue 
      for(int i = 0; i<10000; i++){
         IntQueueArr.enqueue((int) (Math.random()*100));
      }
      
      System.out.println(IntQueueArr.toString());
      System.out.println(IntQueueArr.isEmpty());
      
      
     //make the queue small, but in that way it just works for deleting 5000 elements... 
     //  for(int i =0; i< 5000; i++){
//             IntQueueArr.dequeue();
//       }
      // System.out.println(IntQueueArr.size());
//       
//       System.out.println(IntQueueArr); // just works (that way),because the toString methode works (that way)
      
      MyIterator<Integer> itArr = IntQueueArr.getIterator();
      while(itArr.hasNext()){
         IntQueueArr.dequeue();
      }
      
      System.out.println(IntQueueArr.size());
      System.out.println(IntQueueArr);
     
   
   
    QueueLinked<Integer> IntQueueLinked = new QueueLinked <Integer>();
       
       //filling the queue 
      for(int i = 0; i<10000; i++){
         IntQueueLinked.enqueue((int) (Math.random()*100));
      }
      
      System.out.println(IntQueueLinked.toString());
      System.out.println(IntQueueLinked.isEmpty());
      
      
     //make the queue small, but in that way it just works for deleting 5000 elements... 
     //  for(int i =0; i< 5000; i++){
//             IntQueueArr.dequeue();
//       }
      // System.out.println(IntQueueArr.size());
//       
//       System.out.println(IntQueueArr); // just works (that way),because the toString methode works (that way)
      
      MyIterator<Integer> itLinked = IntQueueLinked.getIterator();
      while(itLinked.hasNext()){
         IntQueueLinked.dequeue();
      }
      
      System.out.println(IntQueueLinked.size());
      System.out.println(IntQueueLinked);
      
      
   }
   
}