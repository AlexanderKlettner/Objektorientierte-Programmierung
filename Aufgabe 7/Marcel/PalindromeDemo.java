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


		//loop over each key for hashmap to get all the sentences in that line
		while(s.hasNextSentence()) {
			
			//get sentence:
			String sen = s.nextSentence();
			
			//Prepare sentence for palindrome function:
			// Kick everything that is not from the alphabet, and convert to lower case
			// so [5] etc will be kiicked as well, but this info is still in object "sen"
			String cleanSen = sen.replaceAll("[^a-zA-Z]", "").toLowerCase();
			boolean pal = PalindromeTest.isPalindrome(cleanSen);
			
			//if palindrome, print the sentence in original form:
			if(pal) {
				//with line number:
				System.out.println(sen);
				
//				//without line number:
//				// get the first occasion of "]"
//				int indexKlammer = sen.indexOf("]");
//				String sen_without_lineNr = sen.substring(indexKlammer+1, sen.length());
//				System.out.println(sen_without_lineNr);
			}
			
	
		}
		
		
		
		
	}
}
