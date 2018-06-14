///import java.*;
import java.util.concurrent.ThreadLocalRandom;

// Klemens Kurtz
public class QueueWithIterator {

	public static void main(String[] args) {
		int min = 10001;
		int max = 15000;
		int randNum = ThreadLocalRandom.current().nextInt(min, max + 1);
				
		
		//Demo QueueLinked:

		QueueLinked<Integer> queue = new QueueLinked<>();
		
		for(int i = 1; i <= randNum; i++) {
			int rand = ThreadLocalRandom.current().nextInt(0, max + 1);
			queue.enqueue(rand);
		}
		
		System.out.println("QueueLinked - size: " + queue.size());
		System.out.println("QueueLinked - dequeue: " + queue.dequeue());		
		System.out.println("QueueLinked - isEmpty: " + queue.isEmpty());
		//System.out.println("QueueLinked - toString: " + queue.toString());
	
				
		// Test iterator:
		MyIterator<Integer> itLinked = queue.getIterator();
		int maxIt = 0;
		int curr = 0;
		while(itLinked.hasNext()) {
			curr = itLinked.getNext();
			if(maxIt < curr) {
				maxIt = curr;
			}
			//System.out.println("QueueArray - Iterator next: " + curr);
		}
		System.out.println("QueueLinked - Iterator - max: " + maxIt);
		
		
		
		//Demo QueueArray:
		
		QueueArray<Integer> queueArr = new QueueArray<>();
				
		for(int i = 1; i <= randNum; i++) {
			int rand = ThreadLocalRandom.current().nextInt(0, max + 1);
			queueArr.enqueue(rand);
		}
		System.out.println();
		System.out.println("QueueArray - size : " + queueArr.size());
		System.out.println("QueueArray - dequeue: " + queueArr.dequeue());		
		System.out.println("QueueArray - isEmpty: " + queueArr.isEmpty());
		//System.out.println("QueueArray - toString: " + queueArr.toString());
		
		
		// Test iterator:
		MyIterator<Integer> itArr = queueArr.getIterator();
		int maxArr = 0;
		int currArr = 0;
		while(itArr.hasNext()) {
			currArr = itArr.getNext();
			if(maxArr < currArr) {
				maxArr = currArr;
			}
			//System.out.println("QueueArray - Iterator next: " + currArr);
		}
		System.out.println("QueueArray - Iterator - max: " + maxArr);	
		
		
		
		// time:
		int length = 15000;
		int runs = 6;
		int operations = 10;
		double which;
		
		for(int i = 0; i < runs; i++) {
			
			for(int m = 0; m <= length; m++) {
				int rand = ThreadLocalRandom.current().nextInt(0, max + 1);
				queue.enqueue(rand);
			}
		
			for(int k = 0; k <= length; k++) {
				int rand = ThreadLocalRandom.current().nextInt(0, max + 1);
				queueArr.enqueue(rand);
			}	
		

			// Start time Linked queue:
			long start = System.currentTimeMillis();
			
			for(int j = 0; j <= operations; j++) {
				which = Math.random();
				if(which < .5) {
					queue.enqueue((int) which*100);
				} else {queue.dequeue();}
			}
		
		
			long end = System.currentTimeMillis();
			System.out.println("QueueLinked Time - " + operations + ": " + (end - start) + " millisec");
			// End of linked queue!
			
			
			// Start time QueueArray:
			long startArr = System.currentTimeMillis();
			
			for(int j = 0; j <= operations; j++) {
				which = Math.random();
				if(which < .5) {
					queueArr.enqueue((int) which*100);
				} else {queueArr.dequeue();}
			}
		
		
			long endArr = System.currentTimeMillis();
			System.out.println("QueueArray Time - " + operations + ": " + (endArr - startArr) + " millisec");
			// End of QueueArray!
			
			
			operations = operations*10;
			
		}
		
		/*
		QueueLinked Time - 10: 0 millisec
		QueueArray Time - 10: 0 millisec
		
		QueueLinked Time - 100: 0 millisec
		QueueArray Time - 100: 0 millisec
		
		QueueLinked Time - 1000: 125 millisec
		QueueArray Time - 1000: 16 millisec
		
		QueueLinked Time - 10000: 1778 millisec
		QueueArray Time - 10000: 63 millisec
		
		QueueLinked Time - 100000: 20952 millisec
		QueueArray Time - 100000: 750 millisec
		
		QueueLinked Time - 1000000: 199013 millisec
		QueueArray Time - 1000000: 9690 millisec
		*/
			
	}

}
