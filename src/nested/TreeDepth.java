package nested;
class TreeNode {
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}
}

public class TreeDepth {

    public static int getNodeDepth(TreeNode root, TreeNode target) {
        return getNodeDepthHelper(root, target, 0);
    }

    private static int getNodeDepthHelper(TreeNode node, TreeNode target, int currentDepth) {
        if (node == null) {
            return -1; // Node not found
        }

        if (node == target) {
            return currentDepth; // Node found, return current depth
        }

        int leftDepth = getNodeDepthHelper(node.left, target, currentDepth + 1);
        int rightDepth = getNodeDepthHelper(node.right, target, currentDepth + 1);

        if (leftDepth != -1) {
            return leftDepth; // Node found in the left subtree
        }

        return rightDepth; // Node found in the right subtree (or not found at all)
    }

    public static void main(String[] args) {
        // Example usage with a binary tree of TreeNode values
        TreeNode leaf1 = new TreeNode(null, null);
        TreeNode leaf2 = new TreeNode(null, null);
        TreeNode rootLeft = new TreeNode(leaf1, null);
        TreeNode rootRight = new TreeNode(null, leaf2);
        TreeNode root = new TreeNode(rootLeft, rootRight);

        int depth = getNodeDepth(root, leaf2);

        if (depth != -1) {
            System.out.println("Depth of node: " + depth);
        } else {
            System.out.println("Node not found in the tree.");
        }
    }
}
