
public class PalindromeTest {

	//Empty constructor
	public PalindromeTest () {
		
	}

	
	public static boolean isPalindrome (String text) {
//		System.out.println("Text: " + text);
		//Case: Only one letter or no letters => Always a palindrome
		if(text.length() == 0 | text.length() == 1) return true;
		else {
			//Check if first and last letter are equal
			String first = text.substring(0, 1); // first letter (start = inc, end = exclusive)
			String last = text.substring(text.length() - 1); // last letter
//			System.out.println("First: " + first + "\nLast: " + last);
			if(first.equals(last)) {
				//send the rest of the string into isPalindrome
				// ex: "Anna", fist A and a will be compared, then "n" and "n" will be sent into 
				// isPalindrome again, and will be compared, then the rest will be sent
				// if the "rest" is empty, then just return true, and dont go into isPalindrom again
				
				// check length of remaining word
				int lenRemain = text.length() - 2; 
				// we cut out 2 elements at most (if string had only 1 element) we would have returned true in first line of this function
				if(lenRemain == 0)return true;
				else {
					String remain = text.substring(1, text.length() - 1); //Send substring without first and last letter into palindrome
					return isPalindrome(remain);
				}
			}else return false;
		}
//		return false;
	}

}
