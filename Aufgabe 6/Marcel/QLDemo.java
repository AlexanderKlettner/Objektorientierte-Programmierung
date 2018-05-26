
public class QLDemo {
	public static void main (String[]args) {
		QueueLinked<String> mQ = new QueueLinked<>();

		mQ.enqueue("Marcel");
		System.out.println(mQ.toString());
		mQ.enqueue("Simone");
		System.out.println(mQ.toString());
		mQ.enqueue("Daniel");
		System.out.println(mQ.toString());
		
		System.out.println("Size of Queue: " + mQ.size());

		System.out.println("Top element: " + mQ.dequeue());
		System.out.println("Size of Queue: " + mQ.size());

		
		System.out.println("Top element: " + mQ.dequeue());
		System.out.println("Size of Queue: " + mQ.size());

		
		System.out.println("Remainder of Queue :" + mQ.toString());

		
		mQ = null;
		
		
		QueueLinked<Integer> mQ_Int = new QueueLinked<>();
		mQ_Int.enqueue(1);
		mQ_Int.enqueue(2);
		mQ_Int.enqueue(3);
		mQ_Int.enqueue(4);
		mQ_Int.enqueue(5);
		mQ_Int.enqueue(6);
		mQ_Int.enqueue(7);
		mQ_Int.enqueue(8);

		

		MyIterator<Integer> it_int = mQ_Int.getIterator();
		
		System.out.println(it_int.hasNext());
		while(it_int.hasNext()) {
			System.out.println(it_int.getNext());
		}
		
		
		
		
	}
}
