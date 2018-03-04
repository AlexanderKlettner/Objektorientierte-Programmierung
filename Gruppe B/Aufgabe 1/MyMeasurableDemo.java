// group consists of: Steger Marcel, Kurtz Klemens, Thiel Konstantin


public class MyMeasurableDemo {
	
	
	public static void main (String[] args){
		
		int anzahl = 5;
		double[] werte = {5.0, 3.5, 10.0, 0.0, 2.75};
		Result result = new Result("MeinName", anzahl);
	      
		for( int i = 0; i < anzahl; i++){
			result.setScore(i, werte[i]);
		}
	         
	      
		// Anwendung des Interface Measurable fuer result::
		System.out.println(result.getMeasure()); 
	    
		
		
	      
		// Salary Demo:
		int month = 12;
		double pay = 2000;
		Salary salary = new Salary("DataScience", month);
	      
		for(int i = 0; i < month; i++) {
			salary.setSalary(i, pay, "mySalary");
		}
	      
		
		// Anwendung des Interface Measurable fuer salary:
		System.out.println(salary.getMeasure());
		
		
		
		
		//
		// erstelle ein Result Array (hier 100 Sportler mit 10 zufälligen scores)
		// und berechne Mittelwert der summierten Scores aller Sportler
		//
		Result[] Sportler = new Result[100];
		
		for (int i = 0; i < Sportler.length; i++) {
			
			String name = "Sportler " + i;
			Sportler[i] = new Result(name, 10);
			
			for(int j = 0; j < Sportler[i].totalScores(); j++)
				Sportler[i].setScore(j, Math.random()*10);	// sets value 0 - 9.99
		}
		
		System.out.println("average score = " + Measurable.getAverage(Sportler));
		
		
	}
}
