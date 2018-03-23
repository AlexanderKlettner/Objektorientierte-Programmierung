import java.util.*;

public class MyQueueDemo{
   public static void main(String[] args){
      MyQueue<Integer> IntQueue = new MyQueue <Integer>();
      MyQueue<Double> DoubleQueue = new MyQueue <Double>();
      MyQueue<String> StringQueue = new MyQueue <String> ();
      
      
      for(int i = 0; i<1000; i++){
         IntQueue.enqueue((int) (Math.random()*100));
      }
      
      for(int i = 0; i<1000; i++){
         DoubleQueue.enqueue((Math.random()*100));
      }
      
      for(int i = 0; i<1000; i++){
         StringQueue.enqueue( "hallo" + i);
      }
      
      
      
      for(int i = 0; i<1000; i++){
         double s = Math.random();
         if(s<=1/3){
            IntQueue.enqueue(-1);
         }else if (s<=2/3){
            IntQueue.dequeue();
         } else {IntQueue.peak ();}
      }
      
      for(int i = 0; i<1000; i++){
         double s = Math.random();
         if(s<=1/3){
            DoubleQueue.enqueue(-1.0);
         }else if (s<=2/3){
            DoubleQueue.dequeue();
         } else {DoubleQueue.peak ();}
      }
      
      for(int i = 0; i<1000; i++){
         double s = Math.random();
         if(s<=1/3){
            StringQueue.enqueue("-1");
         }else if (s<=2/3){
            StringQueue.dequeue();
         } else {StringQueue.peak ();}
      }
   }
   
}