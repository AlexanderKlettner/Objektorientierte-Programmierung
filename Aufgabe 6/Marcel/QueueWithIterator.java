import java.util.concurrent.ThreadLocalRandom;

public class QueueWithIterator {
	public static void main (String[]args) {
		
		// Queues for Integers:
		//ArrayList Queue:
		QueueArray<Integer> q_AL_int = new QueueArray<>();
		//LinkedQueue:
		QueueLinked<Integer> q_L_int = new QueueLinked<>();
		
		//Fill Queues with 10k random integers
		int numberOfIntegers = 10000;
		int randomNumAL;
		int randomNumQL;
		
		for(int i = 0; i < numberOfIntegers; i++) {
			
			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			randomNumAL = ThreadLocalRandom.current().nextInt(0, 1000000 + 1);
			randomNumQL = ThreadLocalRandom.current().nextInt(0, 1000000 + 1);
			
			q_AL_int.enqueue(randomNumAL);
			q_L_int.enqueue(randomNumQL);
			
		}
		
		// Compare speed of Iterators:

		MyIterator<Integer> it_AL = q_AL_int.getIterator();
		MyIterator<Integer> it_L = q_L_int.getIterator();

		long itTimeStart = System.currentTimeMillis();
		while(it_AL.hasNext()) {
			it_AL.getNext();
		}
		long tPassed_AL = System.currentTimeMillis() - itTimeStart ;
		System.out.println("Time passed for AL iterator: " + tPassed_AL);
		
		itTimeStart = System.currentTimeMillis();
		while(it_L.hasNext()) {
			it_L.getNext();
		}
		long tPassed_L = System.currentTimeMillis() - itTimeStart ;
		System.out.println("Time passed for LinkedQueue iterator: " + tPassed_L);
		
		
		
		//Now do random operations
		
		//ArrayList
		int numberOperations = 100000000;
		long startTimeAL = System.currentTimeMillis();
		for(int i = 0; i < numberOperations; i ++) {
			if(enq()) {
				q_AL_int.enqueue(ThreadLocalRandom.current().nextInt(0, 1000000 + 1));
			}else q_AL_int.dequeue();
		}
		System.out.println("Time for " + numberOperations + " operations with ArrayList in seconds: " + (long)(System.currentTimeMillis() - startTimeAL)/1000);
			
		
		//LinkedQueue:
		long starTimeLQ = System.currentTimeMillis();
		for(int i = 0; i < numberOperations; i ++) {
			if(enq()) {
				q_L_int.enqueue(ThreadLocalRandom.current().nextInt(0, 1000000 + 1));
			}else q_L_int.dequeue();
		}
		System.out.println("Time for " + numberOperations + " operations with LinkedQueue in seconds: " + (long)(System.currentTimeMillis() - starTimeLQ)/1000);
		
		
		
	}
	//returns true, if enqueue is next move
	//false if dequeue is next move
	private static boolean enq() {
		int ran = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		return ran == 1;
	}
}
