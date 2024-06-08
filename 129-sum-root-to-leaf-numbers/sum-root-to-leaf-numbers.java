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
    public int sumNumbers(TreeNode root) {
        return pathSum(root, 0);
    }
    private int pathSum(TreeNode root, int runningSum) {
        if (root == null) {
            return 0;
        }
        
        runningSum = runningSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return runningSum;
        }
        int leftPath = pathSum(root.left, runningSum);
        int rightPath = pathSum(root.right, runningSum);
        return leftPath + rightPath;
    }
}