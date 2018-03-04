// group consists of: Steger Marcel, Kurtz Klemens, Thiel Konstantin


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


	//How many elements deos the array have?
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
		
		if((which >= 0) && (which < this.anzahl)) {
			this.salary[which] = salary;
			this.name[which] = name;
		}
	}

	
	//returns score which
	public double getSalary (int which){
		
		if((which >= 0) && (which < this.anzahl)) { 
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

	
	//returns a string representation 
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

