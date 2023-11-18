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
    class Type {
        boolean isBalanced;
        int height;
        public Type (int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    
    private Type dfs(TreeNode root) {
        if (root == null) return new Type(0, true);
        
        Type left = dfs(root.left);
        Type right = dfs(root.right);
        
        boolean isBalanced = left.isBalanced && right.isBalanced 
            && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        
        return new Type(height, isBalanced);
    }
}