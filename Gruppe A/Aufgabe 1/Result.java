public class Result implements Measurable{
   private String name1;
   private double[] scoresarr;
   private int scores;
   
   public Result(String name, int scores){
      name1=name;
      scoresarr = new double[scores];
   }
   
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
