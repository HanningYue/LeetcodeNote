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
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, TreeNode leftMaxRoot, TreeNode rightMinRoot) {
        if (root == null) {
            return true;
        }

        boolean leftTrue = isBST(root.left, leftMaxRoot, root);
        boolean rightTrue = isBST(root.right, root, rightMinRoot);

        boolean currentTrue = leftTrue && rightTrue;
        if (leftMaxRoot != null && leftMaxRoot.val >= root.val
        ||  rightMinRoot != null && rightMinRoot.val <= root.val) {
            return false;
        }
        return currentTrue;
    }
}