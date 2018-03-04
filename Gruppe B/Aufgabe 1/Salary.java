// 00912416 Klemens Kurtz; 
public class Salary implements Measurable {
	
	private String job;
	private int anzahl;
	private double[] salary;
	private String[] name;

	
	//constructor for setting the name and the number of scores
	public Salary (String job, int anzahl) {
		this.job = job;
		this.anzahl = anzahl;
		this.salary = new double[anzahl];
		this.name = new String[anzahl];
	}


	//How many elements has array?
	
	public int arrayInd(){
		int len = this.salary.length;
		return len;
	}

	// Interface
	public double getMeasure() {
		return getMeanSalary();
	}

	//sets for score which the given amount
	public void setSalary (int which, double salary, String name) {
		this.salary[which] = salary;
		this.name[which] = name;
	}

	//returns score which
	public double getSalary (int which){
		// which < this.score, weil score anzahl der Scores ist, aber dann out.ouf.arraybounds waere
		// da das erste Array element ja mit 0 indiziert ist
		// Bsp: Scores = 5, dann gibt es ein 5 elementiges Array
		// a[0], a[1], a[2], a[3] und a[4]
		// aber in a[5] zu suchen, geht nicht. deshalb fange das ab, falls der User den Score haben will
		if(which < this.anzahl) { 
			return this.salary[which];
		}
		else return(0);
	}

	public String jobName() {
		//returns the job name of the object
		return this.job;
	}
	//returns the total score
	public double getMeanSalary(){
		double sumSalary = 0.0;
		double meanSalary = 0.0;
		for (double currentSalary: salary) {
			sumSalary += currentSalary;
		}
		if(this.anzahl == 0) {
			return 0;
		}else {
			meanSalary = (double) sumSalary / this.anzahl;
		}
		
		return meanSalary;
	}

	//returns a string representation of the name combinded with all
	// scores and the total score
	public String toString(){
		
		if(this.anzahl == 0) {
			return "There a no entries\n";
		}
		String end = this.job + " Salary: \n";
		
		for(int i=0; i < anzahl; i++) {
			end += this.name[i] + "'s annual salary: " + salary[i] + " Euro.\n";
		}
		end += "\n Mean Annual Salary: " + this.getMeanSalary();
		return(end);
		

	}

}

