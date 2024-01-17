package leetcode.simple;

import java.util.Scanner;

//input : 52, ans: 5
public class LargestOddNumberInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(largestOddNumber(sc.nextLine()));
		
	}

	public static String largestOddNumber(String num) {
		//char[] charArr = num.toCharArray();
		//int length = charArr.length;
		
		for(int i=num.length()-1; i >= 0; i--) {
			if(Character.getNumericValue(num.charAt(i)) %2 != 0) {
				return num.substring(0, i+1);
			}
		}
		
		return "";
    }
}
