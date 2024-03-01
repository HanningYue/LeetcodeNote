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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        TreeNode originalLeft = root.left;
        TreeNode originalRight = root.right;
        root.left = null;
        root.right = originalLeft;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = originalRight;
        return;
    }
}