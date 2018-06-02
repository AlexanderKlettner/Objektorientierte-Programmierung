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
     //  for(int i =0; i< 10000; i++){
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
     //  for(int i =0; i< 10000; i++){
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
      
//--------------Zeitvergleich--------------------------------------------------------------------            
 
      //filling the queues again
    
      for(int i = 0; i<10000; i++){
         IntQueueArr.enqueue((int) (Math.random()*100));
      }
      
      for(int i = 0; i<10000; i++){
         IntQueueLinked.enqueue((int) (Math.random()*100));
      }
      
      int numberOfOperations = 10000000;
      double decision;
      long time;
      time = System.currentTimeMillis();
      for(int i = 0; i<numberOfOperations;i++){
         decision = Math.random();
         if(decision <0.5){
            IntQueueArr.enqueue((int) (Math.random()*100));
         }else {IntQueueArr.dequeue();}
      }
      time = System.currentTimeMillis() - time;
      System.out.println("Queue mit ArrayList benoetigt fuer " + numberOfOperations + " ungefaehr " + time + " millisec.");
      
      time = System.currentTimeMillis();
      for(int i = 0; i<numberOfOperations;i++){
         decision = Math.random();
         if(decision <0.5){
            IntQueueLinked.enqueue((int) (Math.random()*100));
         }else {IntQueueLinked.dequeue();}
      }
      time = System.currentTimeMillis() - time;
      System.out.println("Queue mit dynamischer Datenstruktur benoetigt fuer " + numberOfOperations + " ungefaehr " + time + " millisec.");
              
   }
   
//QueueArray: 100 Operationen - 0 millisec
//QueueLinked: 100 Operationen - 2 millisec

//QueueArray: 1000 Operationen - 0 millisec
//QueueLinked: 1000 Operationen - 22 millisec

//QueueArray: 10000 Operationen - 2 millisec
//QueueLinked: 10000 Operationen - 216 millisec

//QueueArray: 100000 Operationen - 47 millisec
//QueueLinked: 100000 Operationen - 2189 millisec

//QueueArray: 1000000 Operationen - 450 millisec
//QueueLinked: 1000000 Operationen - 22212 millisec
 
//QueueArray: 10000000 Operationen - 3942 millisec
//QueueLinked: 10000000 Operationen - 307043 millisec

//QueueArray: 100000000 Operationen - 103334 millisec
//QueueLinked: 100000000 Operationen - 1255585 millisec
   
}
