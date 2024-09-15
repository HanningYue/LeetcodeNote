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
    public int maxDepth(TreeNode root) {
        return max(root);
    }
    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = max(root.left);
        int rightHeight = max(root.right);
        
        int currentMax = Math.max(leftHeight, rightHeight) + 1;
        return currentMax;
    }
}