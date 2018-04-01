import java.util.concurrent.ThreadLocalRandom; // For Random Numbers
import java.util.Random;
public class MyQueueDemo {

	public static void main (String[] args) {
		
		MyQueue<String> strQueue = new MyQueue<String>();
//		strQueue.enqueue("Marcel");
//		strQueue.enqueue("Simone");
//		strQueue.enqueue("Raphael");
//		strQueue.enqueue("Constantin");
//		
//		//isempty should be false:
//		System.out.println(strQueue.isEmpty());
//		
//		//peek at first (should be marcel)
//		System.out.println(strQueue.peek());
//		
//		//dequeue first member (Marcel)
//		System.out.println(strQueue.dequeue());
//		// dequeue Simone
//		System.out.println(strQueue.dequeue());
//		
//		
//		//Print whole remaining queue
//		
//		System.out.print(strQueue.toString());
//		
		
		
		// String Demo:
		String startString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int lengthString = startString.length();
		//Now randomly select characters of string from position 0 to lengthString - 1
		
		//Results Placeholder
		String [] strElements = new String [1000];

		int strElementsLengthMin = 5;
		int strElementsLengthMax = 12;
		
		for(int i=0; i < strElements.length-2; i++) {
			
			//Random Number LENGTH betweeen 5 and 12 for length of random String
			int endLength = ThreadLocalRandom.current().nextInt(strElementsLengthMin, strElementsLengthMax);
			//That function gives an integer between first arugment and second argument - 1
			
			char[] element = new char[endLength];
			//from 1 to LENGTH choose a random character from startString
			for(int j = 0; j < endLength-1; j++) {
				int randomCharacter = ThreadLocalRandom.current().nextInt(0, lengthString);
				element[j] = startString.charAt(randomCharacter);
			}


			strElements[i]  = new String(element);
		}
	
		for (int i = 0; i < 1000; i++) {
			strQueue.enqueue(strElements[i]);
		}	
		
		
		System.out.println("size of Queue is: " + strQueue.size());
		
		
		//peek first 5
		for(int i = 0; i < 4; i++) {
			int curr = i + 1;
			System.out.println(curr + ". in Line is: " + strQueue.peekAt(i));
		}
		
		// 1000 random Operations:
		
		
	} // End of Main
	
	public void randomOperation() {
		//Pick Random number between 0 and ... Number of possible Operations
		int rand = ThreadLocalRandom.current().nextInt(0, 3); // Gives random integer numbers between 0 and 2

		if(rand == 0) {
			//first operation: enqueue
		}
		if(rand == 1) {
			//second operation: dequeue
		}
		if(rand == 2) {
			//third operation: peek
		}

		
	}
	
	public int randomInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	
	public String randomString(int minlength, int maxlength) {
		
		
		String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//Random Number LENGTH betweeen minlength and maxlength for length of random String
		int endLength = ThreadLocalRandom.current().nextInt(minlength, maxlength);
		//That function gives an integer between first arugment and second argument - 1
		
		char[] element = new char[endLength];
		//from 1 to LENGTH choose a random character from startString
		for(int j = 0; j < endLength-1; j++) {
			int randomCharacter = ThreadLocalRandom.current().nextInt(0, all.length());
			element[j] = all.charAt(randomCharacter);
		}

		return new String (element);
		
	}
	
	public float randomFloat(int min, int max) {
		Random r = new Random();
		return min + r.nextFloat() * (max - min);
	}
	

}
	

