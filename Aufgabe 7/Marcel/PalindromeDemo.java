
public class PalindromeDemo {
	public static void main(String[]args) {
//		String text = "Lager Regal";
//		text = text.toLowerCase();
//		System.out.println(PalindromeTest.isPalindrome(text));
//		
//		String text1 = "Marcel";
//		text1 = text1.toLowerCase();
//		System.out.println(PalindromeTest.isPalindrome(text1));
//		
		
		SentenceTool s = new SentenceTool("auf7_1.txt");
		System.out.println("\n\nPalindrome Sentences: \n");
		while(s.hasNextSentence()) {
			String sen = s.nextSentence();

			//Clean sentence:
			String cleanSen = sen.replaceAll("[^a-zA-Z]", "").toLowerCase();

			boolean pal = PalindromeTest.isPalindrome(cleanSen);
//			System.out.println(pal);
			if(pal) {
//				System.out.println("Found a palindrome Sentence: \n");
				System.out.println(sen);
			}
		}
		
		
	}
}
