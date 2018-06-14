
public class PalindromeDemo {
	public static void main(String[]args) {
		String text = "Lager Regal";
		PalindromeTest t = new PalindromeTest();
		System.out.println(t.isPalindrome(text));
		
		
		SentenceTool s = new SentenceTool("auf7_1.txt");
		while(s.hasNextSentence()) {
			System.out.println(s.nextSentence());
		}
	}
}
