
public class strsploit {
	public static void main(String[]args) {
		String s = "Simone? Marcel! Walter. Chris!";
		String [] d = s.split("(?<=\\.|\\!|\\?)");  // "[1,][234,][567,][890]"
		
		// dump("1,234,567,890".split("(?<=,)|(?=,)"));
		


		for(int i = 0; i < d.length; i ++) {
			System.out.println(d[i] + "\n");
		}
	}
}
