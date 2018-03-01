public class Result implements Measurable{
   String name;
   int score;
   double[] scoresarr = new double[score];
   
   public Result(String name, int scores){
      this.name=name;
      score=scores;
   }
   
   public void setScore(int which, double amount){
      scoresarr[which] = amount;
   }
   
   public double getScore(int which){
      return scoresarr[which];
   }
   
   public double getTotalScore(){
      double sum = 0;
      for(int i = 0; i<score; i++){
         sum=sum+scoresarr[i];
      }
      return sum;
   }
   
   public String toString(){
      String s =  "";
      for(int i = 0; i<score; i++){
         s=s +" /"+ scoresarr[i];
      }
      return name + ": "+ s + " = " + getTotalScore();
   }
   
   public double getMeasure (){
      return getTotalScore();
   }
      
}