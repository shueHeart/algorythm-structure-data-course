package queue;

public class QueueTwister {
	public static void twist (Queue queue, int N) {
		
		if (queue.size() == 0) return;
		
		int realTwist = N % queue.size();
				
		Queue tail = new Queue();
		Queue head = new Queue();
		
		for (int i = 0; i < realTwist; ++i) {
			tail.enqueue(queue.dequeue());
		}
		
		int size = queue.size();
		for (int i = 0; i < size; ++i) {
			head.enqueue(queue.dequeue());
		}
		
		size = head.size();
		for (int i = 0; i < size; ++i) {
			queue.enqueue(head.dequeue());
		}
		
		size = tail.size();
		for (int i = 0; i < size; ++i) {
			
			queue.enqueue(tail.dequeue());
		}
		
	}
}
