package leetcode.simple;

import java.util.*;

public class TwoSum {

	// given an array of integers and a target sum, and you need to find the two
	// integers in the array that add up to the target sum, and return its index
	
	public static int[] twoSum(int[] nums, int target) {
		// store the element and its index number
		Map<Integer, Integer> encounteredNum = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			System.out.println(String.format("%d , %d = %d", nums[i], i, complement));

			if (encounteredNum.containsKey(complement)) {
				// complement exist in the encountered element
				return new int[] { encounteredNum.get(complement), i };
			}

			encounteredNum.put(nums[i], i);
		}
		// not found
		return new int[] { -2_000_000_000, -2_000_000_000 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] twoSumArr = { 5, 2, 3, 1, 4 };
		int[] arr = twoSum(twoSumArr, 5);

		System.out.println(String.format("%d , %d", arr[0], arr[1]));
	}

}
