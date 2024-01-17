package leetcode.hard;

public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

		int[] nums3 = new int[nums1.length + nums2.length];
		int pointer1 = 0;
		int pointer2 = 0;
		int pointer3 = 0;

		while (pointer1 < nums1.length && pointer2 < nums2.length) {
			if (nums1[pointer1] < nums2[pointer2]) {
				nums3[pointer3] = nums1[pointer1];
				pointer1++;
			} else if (nums1[pointer1] > nums2[pointer2]) {
				nums3[pointer3] = nums2[pointer2];
				pointer2++;
			} else {
				nums3[pointer3] = nums1[pointer1];
				pointer3++;
				nums3[pointer3] = nums2[pointer2];
				pointer1++;
				pointer2++;
			}

			pointer3++;
		}

		while (pointer1 < nums1.length) {
			nums3[pointer3] = nums1[pointer1];
			pointer1++;
			pointer3++;
		}

		while (pointer2 < nums2.length) {
			nums3[pointer3] = nums2[pointer2];
			pointer2++;
			pointer3++;
		}

		int half = nums3.length / 2;
		int remainder = nums3.length % 2;
		if (remainder == 1) {
			return nums3[half];
		}

		return (double) (nums3[half - 1] + nums3[half]) / 2;
	}

	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		//1,2,3,5
		//-5,6,7,8,9
		
		int[] A = nums1; //initialize nums1 is lesser array
		int[] B = nums2;
		
		if(nums2.length < nums1.length) { //if nums2 is lesser
			A = nums2; //interchange
			B = nums1;
		}
		
		double A_Left = 0;
		double A_Right = 0;
		double B_Left = 0;
		double B_right = 0;
		
		int total = nums1.length + nums2.length;
		//get the half index of nums1 and nums2 are merged
		int half = total / 2;
		
		int left_pointer_A = 0;
		int right_pointer_A = A.length - 1;
		
		while(true) {
			int x = (left_pointer_A + right_pointer_A) / 2; //A
			int y = half - x - 2; //B
			
			A_Left = (x < 0) ? Double.NEGATIVE_INFINITY : A[x];
			A_Right = (x + 1) > (A.length - 1) ? Double.POSITIVE_INFINITY : A[x+1];
			B_Left = (y < 0) ? Double.NEGATIVE_INFINITY : B[y];
			B_right = (y + 1) > (B.length - 1) ? Double.POSITIVE_INFINITY : B[y+1];
			
			//partition is correct
			if(A_Left <= B_right && B_Left <= A_Right) {
				if(total % 2 == 1) {
					return Math.min(A_Right, B_right);
				}
				
				return (Math.max(A_Left, B_Left) + Math.min(A_Right, B_right)) / 2;
				
			} else if (A_Left > B_right) {
				right_pointer_A = x - 1;
			}else {
				left_pointer_A = x + 1;
			}
			
		}
		
	}

	public static void main(String[] args) {

		// System.out.println(findMedianSortedArrays1(new int[] { 1, 2 }, new int[] { 3,
		// 4 })); // 2.5

		// System.out.println(findMedianSortedArrays1(new int[] { 1, 3 }, new int[]
		// {2})); // 2.0

		// System.out.println(findMedianSortedArrays1(new int[] {0,0,0,0,0}, new int[]
		// {-1, 0,0,0,0,0,1})); //0.0

		System.out.println(findMedianSortedArrays1(new int[] { 2, 2, 4, 4 }, new int[] { 2, 2, 4, 4 })); // 3.0
		System.out.println(findMedianSortedArrays2(new int[] { 2, 2, 4, 4 }, new int[] { 2, 2, 4, 4 })); // 3.0
	}
}
