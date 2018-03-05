public class MyMeasurableDemo{
   
   public static void main (String[] args){
      double[] werte = {5.0, 3.5, 10.0, 0.0, 2.75};
      double out;
      Result r = new Result("meinName", werte.length);
      
      for( int i = 0; i<werte.length; i++){
         r.setScore(i,werte[i]);
      }
      
      r.getMeasure(); 
      
      System.out.println(r.toString());
      
      Result r1 = new Result("meinName1", werte.length);
      for( int i = 0; i<werte.length; i++){
         r1.setScore(i, i+1);
      }
      
      System.out.println(r1.toString());
      Measurable[] results = {r, r1};
      
      System.out.println("average total score of two people: " + myUtilities.getAverage(results));
      
      
      //DataSPay Demo
      double[] pay = {65.000, 38.000, 77.000, 112.000, 50.000};
      double[] pay2 = {30.000, 43.000, 64.000};
      
      DataSPay dscience1 = new DataSPay("automotive", pay.length);
      
      for(int k = 0; k <pay.length; k++){
         dscience1.setPay(k, pay[k]);
      }
      
      dscience1.getMeasure();
      
      System.out.println(dscience1.toString());
      
      DataSPay dscience2 = new DataSPay("financial", pay2.length);
      for(int m = 0; m<pay2.length; m++){
         dscience2.setPay(m, pay2[m]);
      }
      
      dscience2.getMeasure();
      
      System.out.println(dscience2.toString());
      
      Measurable[] ergebnisse = {dscience1, dscience2};
      
      System.out.println("average income = " + myUtilities.getAverage(ergebnisse));
   }
}
