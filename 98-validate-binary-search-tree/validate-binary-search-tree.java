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
        return valid(root, null, null);
    }
    private boolean valid(TreeNode root, TreeNode leftBound, TreeNode rightBound) {
        if (root == null) {
            return true;
        }
        boolean leftTrue = valid(root.left, leftBound, root);
        boolean rightTrue = valid(root.right, root, rightBound);
        if (leftBound != null && root.val <= leftBound.val
        || rightBound != null && root.val >= rightBound.val) 
        {
            return false;    
        }

        boolean currentTrue = leftTrue && rightTrue;
        return currentTrue;
    }
}