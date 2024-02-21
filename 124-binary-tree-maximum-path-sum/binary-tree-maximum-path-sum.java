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
        dfs(root);
        return globalMax;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left < 0) {
            left = 0;
        }

        int right = dfs(root.right);
        if (right < 0) {
            right = 0;
        }

        globalMax = Math.max(globalMax, left + right + root.val);
        int currentMax = Math.max(left, right) + root.val;
        return currentMax;
    }
}