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
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return true;
        }
        boolean leftValid = isValid(root.left, left, root);
        boolean rightValid = isValid(root.right, root, right);
        if (left != null && root.val <= left.val) {
            return false;
        }
        if (right != null && root.val >= right.val) {
            return false;
        }
        boolean currentValid = leftValid && rightValid;
        return currentValid;
    }
}