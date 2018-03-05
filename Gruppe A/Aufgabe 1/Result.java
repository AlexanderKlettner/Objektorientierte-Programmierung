/*************************************************** 
Class for Testresults + Names
UV Objektorientierte Programmierung / #TeamDataSciene
Team: Simone Müller, Alexander Klettner
***************************************************/

public class Result implements Measurable{
   private String name1;
   private double[] scoresarr;
   
// Konstruktor:   
   
   public Result(String name, int scores){
      name1=name;
      scoresarr = new double[scores];
   }

// Methoden:

   public void setScore(int which, double amount){
      scoresarr[which] = amount;
   }
   
   public double getScore(int which){
      return scoresarr[which];
   }
   
   public double getTotalScore(){
      double sum = 0;
      for(int i = 0; i<scoresarr.length; i++){
         sum=sum+scoresarr[i];
      }
      return sum;
   }
   
   public String toString(){
      String s =  "";
      for(int i = 0; i<scoresarr.length; i++){
         if( i ==0){
            s=s + scoresarr[i];
         } else{
         s=s +" /"+ scoresarr[i];
         }
      }
      return name1 + ": "+ s + " = " + getTotalScore();
   }
   
   public double getMeasure (){
      return getTotalScore();
   }
      
}
