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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return pathSum(root, 0, targetSum);
    }
    private boolean pathSum(TreeNode root, int runningSum, int targetSum) {
        if (root == null) {
            return false;
        }

        runningSum += root.val;
        if (root.left == null && root.right == null && runningSum == targetSum) {
            return true;
        }
        boolean leftPath = pathSum(root.left, runningSum, targetSum);
        boolean rightPath = pathSum(root.right, runningSum, targetSum);
        return leftPath || rightPath;
    }
}