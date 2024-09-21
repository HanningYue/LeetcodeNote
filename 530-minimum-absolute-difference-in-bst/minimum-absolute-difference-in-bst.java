/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (previous != null) {
                if (Math.abs(previous.val - root.val) < result) {
                    result = Math.abs(previous.val - root.val);
                }
            }
            previous = root;
            root = root.right;
        }
        return result;
    }
}