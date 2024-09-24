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
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return globalMax;
    }
    private int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = pathSum(root.left);
        leftPath = Math.max(leftPath, 0);

        int rightPath = pathSum(root.right);
        rightPath = Math.max(rightPath, 0);

        globalMax = Math.max(globalMax, leftPath + rightPath + root.val);
        int currentMax = Math.max(leftPath, rightPath) + root.val;
        return currentMax;
    }
}