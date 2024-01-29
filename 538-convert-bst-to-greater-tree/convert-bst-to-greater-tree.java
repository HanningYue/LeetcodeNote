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
 //We are essentially asking for the sum of all right tree + current root val
 //Notice that the greater the original value of the root is, the smaller their Greater tree value will be
 //So we need a descending order of original tree, inorder, but from right to left
class Solution {
    public TreeNode convertBST(TreeNode root) {
        inorder(root, new int[]{0});
        return root;
    }
    private int[] inorder(TreeNode root, int[] sum) {
        if (root == null) {
            return new int[]{0};
        }
        inorder(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        inorder(root.left, sum);
        return sum;
    }
}