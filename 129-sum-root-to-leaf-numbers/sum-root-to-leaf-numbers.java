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
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int runningSum) {
        if (root == null) {
            return;
        }
        
        runningSum = runningSum * 10 + root.val;
        dfs(root.left, runningSum);
        dfs(root.right, runningSum);
        
        if (root.left == null && root.right == null) {
            result += runningSum;
        }
    }
}