// group consists of: Steger Marcel, Kurtz Klemens, Thiel Konstantin


public interface Measurable {

	//returns the specific measure
	public double getMeasure ();  
	
	
	
	//return the average of the data-objects measures
	//null-references are not counted
	public static double getAverage (Measurable[] data){
	
		double sum = 0.0;
		int count = 0;
		for (Measurable m: data)
			if (m != null){
				sum = sum + m.getMeasure();
				count++;
			}
		if (count == 0)
		  return 0.0;
		else
			return sum / count;
	}
}


