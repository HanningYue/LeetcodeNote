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
        int leftSum = pathSum(root.left);
        if (leftSum < 0) {
            leftSum = 0;
        }

        int rightSum = pathSum(root.right);
        if (rightSum < 0) {
            rightSum = 0;
        }

        int currentSum = Math.max(leftSum, rightSum) + root.val;
        globalMax = Math.max(globalMax, root.val + leftSum + rightSum);
        return currentSum;
    }
}