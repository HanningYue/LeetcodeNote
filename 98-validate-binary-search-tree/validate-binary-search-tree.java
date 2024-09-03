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
        return BST(root, null, null);
    }
    private boolean BST(TreeNode root, TreeNode leftMax, TreeNode rightMin) {
        if (root == null) {
            return true;
        }

        boolean leftTrue = BST(root.left, leftMax, root);
        boolean rightTrue = BST(root.right, root, rightMin);
        if (leftMax != null && root.val <= leftMax.val
        || rightMin != null && root.val >= rightMin.val) {
            return false;
        }

        return leftTrue && rightTrue;
    }
}