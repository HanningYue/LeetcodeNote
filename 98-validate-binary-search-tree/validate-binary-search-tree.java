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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    private boolean dfs(TreeNode root, TreeNode leftSubMax, TreeNode rightSubMin) {
        if (root == null) {
            return true;
        }
        boolean leftTrue = dfs(root.left, leftSubMax, root);
        boolean rightTrue = dfs(root.right, root, rightSubMin);
        boolean currentTrue = leftTrue && rightTrue;
        if (leftSubMax != null && root.val <= leftSubMax.val
        || rightSubMin != null && root.val >= rightSubMin.val) 
        {
            return false;
        }
        return currentTrue;
    }
}