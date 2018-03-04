// 00912416 Klemens Kurtz; 

public class Result implements Measurable {
	
	private String name;
	private int scores;
	private double[] amount;
	
	//constructor for setting the name and the number of scores
	public Result (String name, int scores) {
		this.name = name;
		this.scores = scores;
		this.amount = new double[scores];
	}


	//How many elements has array?
	
	public int arrayInd(){
		int len = this.amount.length;
		return len;
	}

	// Interface
	public double getMeasure() {
		return getTotalScore();
	}

	//sets for score which the given amount
	public void setScore (int which, double amount) {
		this.amount[which] = amount;
	}

	//returns score which
	public double getScore (int which){
		// which < this.score, weil score anzahl der Scores ist, aber dann out.ouf.arraybounds waere
		// da das erste Array element ja mit 0 indiziert ist
		// Bsp: Scores = 5, dann gibt es ein 5 elementiges Array
		// a[0], a[1], a[2], a[3] und a[4]
		// aber in a[5] zu suchen, geht nicht. deshalb fange das ab, falls der User den Score haben will
		if(which < this.scores) { 
			return this.amount[which];
		}
		else return(0);
	}

	//returns the total score
	public double getTotalScore (){
		double totalScore = 0.0;
		for (double currentScore: amount) {
			totalScore += currentScore;
		}
		return totalScore;
	}

	//returns a string representation of the name combinded with all
	// scores and the total score
	public String toString(){
		
		String end = this.name + ": ";
		
		for(double currentScore: amount) {
			end += currentScore + " / ";
		}
		end += " = " + this.getTotalScore();
		return(end);
		

	}

}

