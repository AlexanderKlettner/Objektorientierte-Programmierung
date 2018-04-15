
import java.util.concurrent.ThreadLocalRandom;

public class MyStackDemo {
	public static void main(String[] args) {

		// Dynamic Data Structures:
		StackDynamic<Integer> stackInt = new StackDynamic<>();
		StackDynamic<String> stackStr = new StackDynamic<>();
		StackDynamic<Character> stackChar = new StackDynamic<>();



		// 1k random operations for stackInt
		for (int i = 0; i < 1000; i++) {
			randomOperationInt(stackInt);
		}
		// 1k random operations for stackStr
		for (int i = 0; i < 1000; i++) {
			randomOperationString(stackStr);
		}
		// 1k random operations for stackChar
		for (int i = 0; i < 1000; i++) {
			randomOperationChar(stackChar);
		}

		// Final Sizes of Stacks

		System.out.println("Output for Dynamic Stack:");
		System.out.println("Size of Character Stack: " + stackChar.getSize());
		System.out.println("Size of Integer Stack: " + stackInt.getSize());
		System.out.println("Size of String Stack: " + stackStr.getSize());

		// Print Dynamic Stacks:
		System.out.println("Character Stack: \n" + stackChar.toString());
		System.out.println("Integer Stack: \n" + stackInt.toString());
		System.out.println("String Stack: \n" + stackStr.toString());
		
		
		
		
		
		// Demo for StackArray

		StackArray<String> strSArray = new StackArray<>();
		StackArray<Integer> intSArray = new StackArray<>();
		StackArray<Character> charSArray = new StackArray<>();
		

		// 1k random operations for intSArray
		for (int i = 0; i < 1000; i++) {
			randomOperationInt(intSArray);
		}
		// 1k random operations for strSArray
		for (int i = 0; i < 1000; i++) {
			randomOperationString(strSArray);
		}
		// 1k random operations for charSArray
		for (int i = 0; i < 1000; i++) {
			randomOperationChar(charSArray);
		}


		// Final Sizes of Stack Arrays
		System.out.println("");
		System.out.println("Output for StackArray:");
		System.out.println("Size of Character Stack: " + charSArray.getSize());
		System.out.println("Size of Integer Stack: " + intSArray.getSize());
		System.out.println("Size of String Stack: " + strSArray.getSize());

		// Print StackArrays:
		System.out.println("Character Stack: \n" + charSArray.toString());
		System.out.println("Integer Stack: \n" + intSArray.toString());
		System.out.println("String Stack: \n" + strSArray.toString());

	
		// Time Comparisons:
		
		long beginArrayList = System.currentTimeMillis();
	    for (int i = 0; i < 1000000; i ++)
	    	 randomOperationInt(intSArray);
	    long endArrayList = System.currentTimeMillis();
	    long passedArrayList = endArrayList - beginArrayList;
	    System.out.println("Time passed for int ArrayList: " + passedArrayList);
	    
	    
		long beginDStack = System.currentTimeMillis();
	    for (int i = 0; i < 1000000; i ++)
	    	randomOperationInt(stackInt);
	    long endDStack = System.currentTimeMillis();
	    long passedDStack = endDStack - beginDStack;
	    System.out.println("Time passed for int Dynamic Stack: " + passedDStack);
	    
	    
	}
	

	// Functions for random Operations:

	// General:

	public static int CreateRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	public static char CreateRandom(boolean upper, boolean lower) {
		char result;

		String AllChars = "abcdefghijklmnopqrstuvwxyz";

		if (upper & !lower)
			AllChars = AllChars.toUpperCase();
		// if(!upper & lower) //nothing happens
		if (upper & lower)
			AllChars = AllChars + AllChars.toUpperCase();
		if (!lower & !upper)
			throw new IllegalArgumentException();

		int randomCharacter = ThreadLocalRandom.current().nextInt(0, AllChars.length());
		result = AllChars.charAt(randomCharacter);

		return result;
	}
	public static String CreateRandom(int minlength, int maxlength, boolean upper, boolean lower) {

		String all = "";
		String begin = "abcdefghijklmnopqrstuvwxyz";

		// Decide which case:
		if (upper & !lower) {
			// Just upper Case:
			all = begin.toUpperCase();
		}
		if (lower & !upper) {
			// Just lower case:Nothing changes..
			all = begin;
		}
		if (lower & upper) {
			// Both:
			all = begin.toUpperCase() + begin;
		}
		if (!lower & !upper)
			throw new IllegalArgumentException();

		// Random Number LENGTH betweeen minlength and maxlength for length of random
		// String
		int endLength = ThreadLocalRandom.current().nextInt(minlength, maxlength);
		// That function gives an integer between first arugment and second argument - 1

		char[] element = new char[endLength];
		// from 1 to LENGTH choose a random character from startString
		for (int j = 0; j < endLength; j++) {
			int randomCharacter = ThreadLocalRandom.current().nextInt(0, all.length());
			element[j] = all.charAt(randomCharacter);
		}

		return new String(element);
	}

	// Dynamic Structures:
	public static void randomOperationInt(StackDynamic<Integer> stack) {

		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);

		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2,
		// else 3
		if (rand <= 40) {

			// first operation: push
			stack.push(CreateRandom(1, 999));

		} else if (rand <= 80) {
			// second operation: pop
			// Only pop, if stack is not empty
			if (!stack.isEmpty()) {
				stack.pop();
			}

		} else {
			// third operation: peek
			if (!stack.isEmpty()) {
				stack.peek();
			}
		}
	}
	public static void randomOperationString(StackDynamic<String> stack) {

		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);

		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2,
		// else 3
		if (rand <= 40) {

			// first operation: push
			stack.push(CreateRandom(4, 12, true, true));

		} else if (rand <= 80) {
			// second operation: pop
			if (!stack.isEmpty()) {
				stack.pop();
			}

		} else {
			// third operation: peek
			if (!stack.isEmpty()) {
				stack.peek();
			}
		}
	}
	public static void randomOperationChar(StackDynamic<Character> stack) {

		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);

		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2,
		// else 3
		if (rand <= 40) {

			// first operation: push
			stack.push(CreateRandom(true, true));

		} else if (rand <= 80) {
			// second operation: pop
			if (!stack.isEmpty()) {
				stack.pop();
			}

		} else {
			// third operation: peek

			if (!stack.isEmpty()) {
				stack.peek();
			}
		}
	}

	// ArrayList
	public static void randomOperationInt(StackArray<Integer> stack) {

		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);

		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2,
		// else 3
		if (rand <= 40) {

			// first operation: push
			stack.push(CreateRandom(1, 999));

		} else if (rand <= 80) {
			// second operation: pop
			// Only pop, if stack is not empty
			if (!stack.isEmpty()) {
				stack.pop();
			}

		} else {
			// third operation: peek
			if (!stack.isEmpty()) {
				stack.peek();
			}
		}
	}
	public static void randomOperationString(StackArray<String> stack) {

		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);

		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2,
		// else 3
		if (rand <= 40) {

			// first operation: push
			stack.push(CreateRandom(4, 12, true, true));

		} else if (rand <= 80) {
			// second operation: pop
			if (!stack.isEmpty()) {
				stack.pop();
			}

		} else {
			// third operation: peek
			if (!stack.isEmpty()) {
				stack.peek();
			}
		}
	}
	public static void randomOperationChar(StackArray<Character> stack) {

		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);

		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2,
		// else 3
		if (rand <= 40) {

			// first operation: push
			stack.push(CreateRandom(true, true));

		} else if (rand <= 80) {
			// second operation: pop
			if (!stack.isEmpty()) {
				stack.pop();
			}

		} else {
			// third operation: peek

			if (!stack.isEmpty()) {
				stack.peek();
			}
		}
	}

	

}
