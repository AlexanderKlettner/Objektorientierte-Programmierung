

public class ResultsDemo {

	public static void main (String[] args){
	
		


      Result Marcel = new Result("Marcel", 5);
      


      Marcel.setScore(0, 10.52);
      Marcel.setScore(1, 9.52);
      Marcel.setScore(2, 7.52);
      Marcel.setScore(3, 6.52);
      Marcel.setScore(4, 4.00);
      
      

      double score2 = Marcel.getScore(5); // 9.52
      System.out.print("Marcels 2. Score: " + score2 + "\n");
      
      System.out.print("Marcels Total Score: " + Marcel.getTotalScore() + "\n");
      
      
      System.out.printf(Marcel.toString());
     
	} 
}