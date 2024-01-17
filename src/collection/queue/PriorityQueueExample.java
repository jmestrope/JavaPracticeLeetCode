package collection.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(1);
		pq.add(2);
		pq.add(3);
		pq.add(5);
		pq.add(4);
		
		System.out.println(pq.toString());
		
		Iterator<Integer> iterator = pq.iterator();
		while(iterator.hasNext()) {
			System.out.println(pq.poll()); //poll to remove first element and print
		}
		
		System.out.println(pq);
	}

}
