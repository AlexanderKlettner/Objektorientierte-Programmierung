import java.util.Iterator;


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
//		
		SentenceTool s = new SentenceTool("auf7_1.txt");
		System.out.println("Number of sentences via size function: " + s.size());
		System.out.println("\n\nPalindrome Sentences: \n");

	
		Iterator<Integer> hmIt = s.mhIterator();
		
		//loop over each key for hashmap to get all the sentences in that line
		while(hmIt.hasNext()) {
			int lineCount = hmIt.next();
			Iterator<String> lineIt = s.lineIterator(lineCount);
			//Now iterator over all the sentences in that line:
			while(lineIt.hasNext()) {
				String sen = lineIt.next();
				//Prepare Sentence:
				String cleanSen = sen.replaceAll("[^a-zA-Z]", "").toLowerCase();

				boolean pal = PalindromeTest.isPalindrome(cleanSen);
				if(pal) {
//					System.out.println("Found a palindrome Sentence: \n");
				
					System.out.println("[" + lineCount + "]: " + sen);
				}
			}
		}
		
		
		
		
	}
}
