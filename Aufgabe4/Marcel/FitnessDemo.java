
public class FitnessDemo {
	public static void main (String[] args) {
		 Training sportler = new Training();
		 
		 
		 sportler.addTraining("Marcel", 25.81);
		 sportler.addTraining("Marcel", 12.18);
		 
		 System.out.println(sportler.toString("Marcel"));
		 
		 System.out.println("Methode getAll: \n" + sportler.getAll("Marcel"));
		 
		 
		 System.out.println("Size of Marcels Trainings: \n" + sportler.getAll("Marcel").size());
		 
		 System.out.println("Mittlere Trainingszeit Marcel: \n" + sportler.getAverage("Marcel"));
		 System.out.println("Minimale  Trainingszeit Marcel: \n" + sportler.getMin("Marcel"));
		 System.out.println("Maximale  Trainingszeit Marcel: \n" + sportler.getMax("Marcel"));
		 

		 sportler.addTraining("Simone", 40.18);
		 sportler.addTraining("Simone", 22.5);
		 sportler.addTraining("Simone", 14.18);
		 sportler.addTraining("Simone", 29.8);


		 System.out.println("OverAll Maximum: " + sportler.getOverallMax());
		 	
		 
		 
		 
	}
}
