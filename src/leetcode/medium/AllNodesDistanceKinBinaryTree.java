package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class AllNodesDistanceKinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode searchTargetFromRoot(TreeNode current, TreeNode target) {
		if (current.val == target.val) {
			return current;
		}
		
		//search all left, once null, go right
		if (current.left == null) {
			return searchTargetFromRoot(current.right, target);
		}

		return searchTargetFromRoot(current.left, target);
	}
	
	//k should not be 0
	public List<Integer> getListOfNodeWithForwardDistance(TreeNode current, List<Integer> listOfInteger, int k) {
		
		//getting forward, until k = 0, represent the distance
		if (k > 1) {
			if(current.left != null)
			getListOfNodeWithForwardDistance(current.left, listOfInteger, k - 1);
		}
		if (k == 1) {
			if(current.left != null)
			listOfInteger.add(current.left.val);
			if(current.right != null)
			listOfInteger.add(current.right.val);
		}
		return listOfInteger;
	}

	public List<Integer> getListOfNodeWithBackwardDistance(TreeNode current, List<Integer> listOfInteger, int offset) {

		// getting forward, until offset = 0, represent the distance
		if (offset > 1) {
			if (current.left != null)
				getListOfNodeWithForwardDistance(current.left, listOfInteger, offset - 1);
		}
		if (offset == 1) {
			if (current.left != null)
				listOfInteger.add(current.left.val);
			if (current.right != null)
				listOfInteger.add(current.right.val);
		}
		return listOfInteger;
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> list = new ArrayList<>();
		Deque<Integer> visited = new ArrayDeque<>();
		Deque<Integer> queue = new ArrayDeque<>();
		boolean isFound = false;
		HashMap<Integer, TreeNode> hmLeft = new HashMap<>();
		HashMap<Integer, TreeNode> hmRight = new HashMap<>();
		int levelForward = 0;
		int levelBackward = 0;

		// find the target
		if (root.val == target.val) {
			isFound = true;
		}
		// get the backward element
		// get the forward element
		if (levelForward == k) {

		}

		return list;
	}

}
