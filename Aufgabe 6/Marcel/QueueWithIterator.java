import java.util.concurrent.ThreadLocalRandom;

public class QueueWithIterator {
	public static void main (String[]args) {
		
		//Test functionalities:
		
//		// Test ArrayList Queue
//		QueueArray<String> QA_str = new QueueArray<>();
//		QA_str.enqueue("Marcel");
//		System.out.println(QA_str.toString());
//		QA_str.enqueue("Simone");
//		System.out.println(QA_str.toString());
//		QA_str.enqueue("Daniel");
//		System.out.println(QA_str.toString());
//		QA_str.enqueue("Frieda");
//		System.out.println(QA_str.toString());
//
//		System.out.println("First in Queue: " + QA_str.peek());
//		
//		
//		MyIterator<String> it_qa_str = QA_str.getIterator();
//		while(it_qa_str.hasNext()) {
//			System.out.println("Element: " + it_qa_str.getNext());
//		}
//		
//		//Dequeue 5 times (once more than elements in queue)
//		for(int i = 0; i<5; i++) {
//			System.out.println("Top Element " + QA_str.dequeue());
//		}
//		QA_str.enqueue("Marcel");
//		System.out.println("Queue: \n" + QA_str.toString());
//		
//		
		// Test LinkedQueue
		
		System.out.println("\n\n");
		
		
		System.out.println("Enqueue Items and print them");
	
		QueueLinked<Integer> QA_l = new QueueLinked<>();
		QA_l.enqueue(22);
		System.out.println(QA_l.toString());
		QA_l.enqueue(4);
		System.out.println(QA_l.toString());
		QA_l.enqueue(5);
		System.out.println(QA_l.toString());
		QA_l.enqueue(7);
		System.out.println(QA_l.toString());


		//Peek at firs telement in queue ( next to get out)
		System.out.println("First Element: " + QA_l.peek());
		
		
		MyIterator<Integer> it_ql_int = QA_l.getIterator();
		while(it_ql_int.hasNext()) {
			System.out.println("Element: " + it_ql_int.getNext());
		}
		
		
		//Dequeue 5 times (once more than elements in queue)
		for(int i = 0; i<5; i++) {
			System.out.println("Top Element " + QA_l.dequeue());
		}
		
		//Add new item, to check if an emptied queue can be filles up again
		QA_l.enqueue(4);
		System.out.println("First element: " + QA_l.peek());
		
		
		
		
		
//		
//		// Queues for Integers:
//		//ArrayList Queue:
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
		System.out.println("Time passed for ArrayList iterator in ms: " + tPassed_AL);
		
		itTimeStart = System.currentTimeMillis();
		while(it_L.hasNext()) {
			it_L.getNext();
		}
		long tPassed_L = System.currentTimeMillis() - itTimeStart ;
		System.out.println("Time passed for LinkedQueue iterator in ms: " + tPassed_L);
		
		
		
		//Now do random operations
		
		//ArrayList
		int numberOperations = 10000000;
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
