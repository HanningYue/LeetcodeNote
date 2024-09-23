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
    public int countNodes(TreeNode root) {
        TreeNode leftMost = root;
        int leftHeight = 0;
        while (leftMost != null) {
            leftMost = leftMost.left;
            leftHeight++;
        }

        TreeNode rightMost = root;
        int rightHeight = 0;
        while (rightMost != null) {
            rightMost = rightMost.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        return helper(root);
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSub = helper(root.left);
        int rightSub = helper(root.right);
        return leftSub + rightSub + 1;
    }
}