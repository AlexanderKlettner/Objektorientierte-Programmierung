import java.util.concurrent.ThreadLocalRandom; // For Random Numbers
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
public class MyQueueDemo {

	public static void main (String[] args) {
		
		MyQueue<String> strQueue = new MyQueue<>();
		MyQueue<Integer> intQueue = new MyQueue<>();
		MyQueue<Double> doubleQueue = new MyQueue<>();
		
		
		//Fill String Queue:
		
		for(int i = 0; i < 1000; i++) {
			String strToAdd = CreateRandom(1, 12, true, true);
			strQueue.enqueue(strToAdd);
		}
		
		
	
		
		// 1000 Random Operations on String Queue:
		
		System.out.println("Peek at Str Queue before:" + strQueue.peekAt(10));
		
		
		for (int i = 0; i < 1000; i++) {
			randomOperationString(strQueue);
		}
		System.out.println("Peek at Str Queue after:" + strQueue.peekAt(10));
		
		
		
		
		//Fill Double Queue:
		
		for(int i = 0; i < 1000; i++) {
			double dblToAdd = CreateRandom(0, 1000, 3);
			doubleQueue.enqueue(dblToAdd);
		}

		
		// 1000 Random Operations on Double Queue:
		
		System.out.println("Peek at Double Queue before:" + doubleQueue.peekAt(10));
		
		
		for (int i = 0; i < 1000; i++) {
			randomOperationDouble(doubleQueue);
		}
		System.out.println("Peek at Double Queue after:" + doubleQueue.peekAt(10));
		
		
		
		//Fill Integer Queue:
		
		for(int i = 0; i < 1000; i++) {
			int intToAdd = CreateRandom(0, 1000);
			intQueue.enqueue(intToAdd);
		}
		
		// 1000 Random Operations on Integer Queue:
		
		System.out.println("Peek at Integer Queue before:" + intQueue.peekAt(10));
		
		
		for (int i = 0; i < 1000; i++) {
			randomOperationInt(intQueue);
		}
		System.out.println("Peek at Integer Queue after:" + intQueue.peekAt(10));
		
		

	} // End of Main

	//Beginning of helper Functions
	public static void randomOperationInt(MyQueue<Integer> queue) {
		//Pick Random number between 0 and ... Number of possible Operations
		int rand = ThreadLocalRandom.current().nextInt(0, 3); // Gives random integer numbers between 0 and 2

		if(rand == 0) {
			//first operation: enqueue
			int item = CreateRandom(0, 1000);
			queue.enqueue(item);
		}
		if(rand == 1) {
			//second operation: dequeue
			queue.dequeue();
		}
		if(rand == 2) {
			//third operation: peek
			queue.peek();
		}

		
	}
	public static void randomOperationDouble(MyQueue<Double> queue) {
		//Pick Random number between 0 and ... Number of possible Operations
		int rand = ThreadLocalRandom.current().nextInt(0, 3); // Gives random integer numbers between 0 and 2

		if(rand == 0) {
			//first operation: enqueue
			double item = CreateRandom(0, 1000, 3);
			queue.enqueue(item);
		}
		if(rand == 1) {
			//second operation: dequeue
			queue.dequeue();
		}
		if(rand == 2) {
			//third operation: peek
			queue.peek();
		}

		
	}
	public static void randomOperationString(MyQueue<String> queue) {
		//Pick Random number between 0 and ... Number of possible Operations
		int rand = ThreadLocalRandom.current().nextInt(0, 3); // Gives random integer numbers between 0 and 2

		if(rand == 0) {
			//first operation: enqueue
			String item = CreateRandom(1, 20, true, true);
			queue.enqueue(item);
		}
		if(rand == 1) {
			//second operation: dequeue
			queue.dequeue();
		}
		if(rand == 2) {
			//third operation: peek
			queue.peek();
		}

		
	}
	public static int CreateRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	public static double CreateRandom(int min, int max, int nrDecPoints) 
	{
		Random r = new Random();
		double nextRand = min + r.nextDouble() * (max-min);
		nextRand = round(nextRand, nrDecPoints);
		return nextRand;
	}
	public static String CreateRandom(int minlength, int maxlength, boolean upper, boolean lower) {
		
		String all = "";
		String begin = "abcdefghijklmnopqrstuvwxyz";
	
		// Decide which case:
		if(upper & !lower) {
			//Just upper Case:
			 all = begin.toUpperCase();
		}
		if(lower & !upper) {
			// Just lower case:Nothing changes..
			 all = begin;
		}
		if(lower & upper) {
			//Both:
			 all = begin.toUpperCase() + begin; 
		}
		if(!(lower & upper)) throw new IllegalArgumentException();
		
		
		
		
		//Random Number LENGTH betweeen minlength and maxlength for length of random String
		int endLength = ThreadLocalRandom.current().nextInt(minlength, maxlength);
		//That function gives an integer between first arugment and second argument - 1
		
		char[] element = new char[endLength];
		//from 1 to LENGTH choose a random character from startString
		for(int j = 0; j < endLength; j++) {
			int randomCharacter = ThreadLocalRandom.current().nextInt(0, all.length());
			element[j] = all.charAt(randomCharacter);
		}

		return new String (element);
	}
 // Helper Function to round when creating random floats...
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}


	
}

