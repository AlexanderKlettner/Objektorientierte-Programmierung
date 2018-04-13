
import java.util.concurrent.ThreadLocalRandom;

public class MyStackDemo {
	public static void main(String[]args) {

		StackDynamic<Integer> stackInt = new StackDynamic<>();
		StackDynamic<String> stackStr = new StackDynamic<>();
		StackDynamic<Character> stackChar = new StackDynamic<>();
//		stack1.push(1);
//		stack1.push(2);
//		stack1.push(3);
//		
//		
//		System.out.println("Peek at first one: " + stack1.peek()); // Works
//		
//		System.out.println("Get Position of Int 1: " + stack1.contains(1)); // should return 3
//		System.out.println("Get Position of Int 2: " + stack1.contains(2)); // should return 2
//		System.out.println("Get Position of Int 3: " + stack1.contains(3)); // should return 1
//		
//		
//		//return all the elments in Stack:
//		System.out.println(stack1.toString()); // should be 1, 2, 3
//		
//		System.out.println("Peek Top: " + stack1.peek());
//		
//		System.out.println("Top Item is: " + stack1.pop());
//		//stack1.peek();
//		System.out.println("New Top Item is now: " + stack1.pop());
//		System.out.println("Peek new top: " + stack1.peek()); // just returns the top one again
//
//		System.out.println("Popped Item: " + stack1.pop());
//		System.out.println("Stack empty?: " + stack1.isEmpty());
//		
//		//Do contains on an empty stack
//		System.out.println("Empty Stack contains 1? " + stack1.contains(1));
		
		

		// 1k random operations for stackInt
		for(int i = 0; i < 1000; i++) {
			randomOperationInt(stackInt);
		}
		// 1k random operations for stackStr
		for(int i = 0; i < 1000; i++) {
			randomOperationString(stackStr);
		}
		// 1k random operations for stackChar
		for(int i = 0; i < 1000; i++) {
			randomOperationChar(stackChar);
		}
		
		//Final Sizes of Stacks

		System.out.println("Size of Character Stack: " + stackChar.getSize());
		System.out.println("Size of Integer Stack: " + stackInt.getSize());
		System.out.println("Size of String Stack: " + stackStr.getSize());
		
		// Print Character Stack:
		System.out.println("Character Stack: \n" + stackChar.toString());
		System.out.println("Integer Stack: \n" + stackInt.toString());
		System.out.println("String Stack: \n" + stackStr.toString());
	}


	public static void randomOperationInt(StackDynamic<Integer> stack) {
			
			int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);
					
			// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2, else 3
			if(rand <= 40) {
				
				//first operation: push
				stack.push(CreateRandom(1, 999)); 
		
			}else if(rand <= 80) {
				//second operation: pop
				//Only pop, if stack is not empty
				if(!stack.isEmpty()) {
					stack.pop();	
				}
				
			}else {
				//third operation: peek
				if(!stack.isEmpty()) {
					stack.peek();
				}			}
		}
	public static void randomOperationString(StackDynamic<String> stack) {
		
		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);
				
		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2, else 3
		if(rand <= 40) {
			
			//first operation: push
			stack.push(CreateRandom(4, 12, true, true)); 
	
		}else if(rand <= 80) {
			//second operation: pop
			if(!stack.isEmpty()) {
				stack.pop();	
			}
			
		}else {
			//third operation: peek
			if(!stack.isEmpty()) {
				stack.peek();
			}		}
	}
	public static void randomOperationChar(StackDynamic<Character> stack) {
		
		int rand = ThreadLocalRandom.current().nextInt(0, 100 + 1);
				
		// 2:2:1 odds: if random number between 0 and .4 => 1; between .4 and .8 => 2, else 3
		if(rand <= 40) {
			
			//first operation: push
			stack.push(CreateRandom(true, true)); 
	
		}else if(rand <= 80) {
			//second operation: pop
			if(!stack.isEmpty()) {
				stack.pop();	
			}
			
		}else {
			//third operation: peek

			if(!stack.isEmpty()) {
				stack.peek();
			}
		}
	}
	public static int CreateRandom(int min, int max) {
				return ThreadLocalRandom.current().nextInt(min, max+1);
			}
	public static char CreateRandom(boolean upper, boolean lower) {
		char result;
		
		String AllChars = "abcdefghijklmnopqrstuvwxyz";
		
		if(upper & !lower) AllChars = AllChars.toUpperCase();
		//if(!upper & lower) //nothing happens
		if(upper & lower) AllChars = AllChars + AllChars.toUpperCase();
		if(!lower & !upper) throw new IllegalArgumentException();
			
		int randomCharacter = ThreadLocalRandom.current().nextInt(0, AllChars.length());
		result = AllChars.charAt(randomCharacter);
		
		return result;
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
		if(!lower & !upper) throw new IllegalArgumentException();
		
		
		
		
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




		
		
}



