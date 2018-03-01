public class MeasurableDemo{
   
   public static void main (String[] args){
      int anz = 5;
      double[] werte = {5.0, 3.5, 10.0, 0.0, 2.75};
      double out;
      Result r = new Result("meinName", anz);
      
      for( int i = 0; i<anz; i++){
         r.setScore(i,werte[i]);
      }
      
      r.getMeasure(); 
      
      System.out.println(r.toString());
   }
}