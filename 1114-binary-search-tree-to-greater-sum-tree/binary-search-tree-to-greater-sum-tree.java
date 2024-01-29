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
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }
    int sum = 0;
    private int inorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
        return sum;
    }
}