// 00912416 Klemens Kurtz; 

public class MyMeasureableDemo {
	public static void main (String[] args){
	      int anzahl = 5;
	      double[] werte = {5.0, 3.5, 10.0, 0.0, 2.75};
	      Result result = new Result("MeinName", anzahl);
	      
	      for( int i = 0; i < anzahl; i++){
	         result.setScore(i, werte[i]);
	      }
	         
	      System.out.println(result.toString());
	      
	      // Anwendung des Interface Measurable:
	      System.out.println(result.getMeasure()); 
	      
	      
	      // Salary Demo:
	      int month = 12;
	      double pay = 2000;
	      Salary salary = new Salary("DataScience", month);
	      
	      for(int i = 0; i < month; i++) {
	    	  salary.setSalary(i, pay, "mySalary");
	      }
	      
	      System.out.println(salary.getMeanSalary());
	      
	   }
}
