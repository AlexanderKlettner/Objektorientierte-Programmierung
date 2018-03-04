// group consists of: Steger Marcel, Kurtz Klemens, Thiel Konstantin


public class Result implements Measurable {
	
	private String name;
	private double[] amount;
	
	
	//constructor for setting the name and the number of scores
	public Result (String name, int scores) {
		this.name = name;
		this.amount = new double[scores];
	}


	//How many elements has array?
	public int totalScores(){
		return amount.length;
	}

	
	// Interface
	public double getMeasure() {
		return getTotalScore();
	}

	
	//sets for score which the given amount
	public void setScore (int which, double amount) {
		
		if ((which >= 0) && (which < this.amount.length))
			this.amount[which] = amount;
	}

	
	//returns score which
	public double getScore (int which){

		if((which >= 0) && (which < this.amount.length))
			return this.amount[which];
		
		else return 0;
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
		
		// we do not want a slash following the last amount. So we better use the standard for-loop instead of the for-each-loop:
		for(int i = 0; i < amount.length; i++) {
			end += amount[i];
			if (i != amount.length-1)
				end += " / ";
		}
		
		end += " = " + this.getTotalScore();
		return end;
	}

	
}

