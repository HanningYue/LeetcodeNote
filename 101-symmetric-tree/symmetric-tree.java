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
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);        
    }
    private boolean dfs(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if (one == null || two == null) {
            return false;
        }
        
        boolean innerEqual = dfs(one.right, two.left);
        boolean outerEqual = dfs(one.left, two.right);
        boolean currentEqual = one.val == two.val;
        return innerEqual && outerEqual && currentEqual;
    }
}