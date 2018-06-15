
public class splitS {
	public static void main(String[]args) {
		String s = "Marcel! Simone? Nathalie.Walterä";
		String [] split = s.split("\\.|\\?|\\!");
		
		for(String sa: split) {
			System.out.println(sa);
		}
	}
}
