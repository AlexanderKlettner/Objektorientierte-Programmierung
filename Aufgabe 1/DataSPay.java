/*************************************************** 
Class Results: simple class for Data Science pay

UV Objektorientierte Programmierung / #TeamDataSciene
***************************************************/

public class DataSPay implements Measurable {

   private String industry; 
   private int number;
   private double[] pay;
	
	//----------constructors
	public DataSPay (String industry, int number){
		this.industry = industry;
		this.number = number;
      pay = new double[number];
	}
	
	//----------methods
	
	//Interface Measurable
	public double getMeasure (){
		return getAveragePay();
	}
   
   public void	setPay(int which, double amount){
      pay[which] = amount;
	}


	public double getPay(int which){
		return pay[which];
	}
   
   public void setIndustry(String description){
      industry = description;
   }
   
   public String getIndustry(){
      return industry;
   }
   
   public double getTotalPay(){
      double ges = 0;
      for(int k = 0; k < pay.length; k++){
         ges = ges+pay[k];
      }
      return ges;

   }
   
   public double getAveragePay(){
      double average = 0;
      if(number != 0){
         average = getTotalPay()/number;
         return average;
      }else{
         return 0.0;
      }
   }
   
   public double getMonthlyAverage(int number){
      double averagemonth = 0;
      averagemonth = getTotalPay()/(number*14);
      return averagemonth;
   
   }

}
