package leetcode.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {

	public static int lengthOfLongestSubstring(String s) {
		int pointer_a = 0;
		int pointer_b = 0;
		int max = 0;
		Set<Character> set_char = new HashSet<>();
		
		while(pointer_b < s.length()) {
			if(set_char.contains(s.charAt(pointer_b))) {
				set_char.remove(s.charAt(pointer_a));
				pointer_a++;
				
			} else {
				set_char.add(s.charAt(pointer_b));
				pointer_b++;
				max = Math.max(set_char.size(), max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwdwkew"));
	}

}
