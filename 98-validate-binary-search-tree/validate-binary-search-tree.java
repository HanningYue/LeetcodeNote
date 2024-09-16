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
        return validate(root, null, null);
    }
    private boolean validate(TreeNode root, TreeNode leftNode, TreeNode rightNode) {
        if (root == null) {
            return true;
        }
        if (leftNode != null && leftNode.val >= root.val
        || rightNode != null && rightNode.val <= root.val) {
            return false;
        }

        boolean leftSub = validate(root.left, leftNode, root);
        boolean rightSub = validate(root.right, root, rightNode);
        return leftSub && rightSub;
    }
}