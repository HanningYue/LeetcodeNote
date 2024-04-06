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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        if (leftSum < 0) {
            leftSum = 0;
        }
        int rightSum = dfs(root.right);
        if (rightSum < 0) {
            rightSum = 0;
        }
        result = Math.max(result, root.val + leftSum + rightSum);
        
        int currentSum = root.val + Math.max(leftSum, rightSum);
        return currentSum;
    }
}