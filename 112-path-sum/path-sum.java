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
        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode root, int targetSum, int runningSum) {
        if (root == null) {
            return false;
        }
        
        runningSum += root.val;
        if (root.left == null && root.right == null && targetSum == runningSum) {
            return true;
        }
        boolean leftPath = pathSum(root.left, targetSum, runningSum);
        boolean rightPath = pathSum(root.right, targetSum, runningSum);
        return leftPath || rightPath;
    }
}