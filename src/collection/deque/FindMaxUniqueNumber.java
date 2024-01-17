package collection.deque;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Input: 5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

Output:
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
 */
public class FindMaxUniqueNumber {

	/**
	 * In this problem, you are given N integers. You need to find the maximum
	 * number of unique integers among all the possible contiguous subarrays of size
	 * M.
	 * 
	 * Note: Time limit is 3 second for this problem.
	 * 
	 * 
	 * Solution :
	 * 
	 * 1. create a collection to store the elements where it adds the first
	 * subarray, remove the last element at the same time add the new element to the
	 * last
	 * 
	 * 2. at the same time, create a set collection to add the unique numbers
	 * 
	 * 3.count the size of set collection and compare to previous max size and get
	 * the maximum
	 * 
	 * 4. to maintain the size m, remove the first element of deque and set, add the
	 * new element to the last
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Instant start = Instant.now();

		// get the number of integers
		int n = sc.nextInt();
		// get the size of subarrays
		int m = sc.nextInt();

		int maxUnique = 0;

		// HashSet only allows unique elements
		HashSet<Integer> uniqueSet = new HashSet<>();
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt(); // get the input
			dq.addLast(num); // add one by one the last input number
			uniqueSet.add(num); // add only the unique

			// if the deque reached the max elements allowed m,
			// get the maximum size of unique set
			// remove the first element of input number

			if (dq.size() == m) {
				maxUnique = Math.max(maxUnique, uniqueSet.size());
				int removed = dq.removeFirst();

				// if the first element that was removed has a duplicate number retained in
				// deque,
				// do nothing, if the removed element does not have duplicate
				// remove it from unique set
				if (!dq.contains(removed)) {
					uniqueSet.remove(removed);
				}
			}
		}
		System.out.println(maxUnique);

		Instant end = Instant.now();

		System.out.println(Duration.between(start, end).getSeconds());
	}
}
