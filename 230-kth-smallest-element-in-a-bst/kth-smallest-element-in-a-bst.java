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
    int k;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return result;
    }
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        k--;
        if (k == 0) {
            result = root.val;
            return;
        }
        inOrder(root.right);
    }
}