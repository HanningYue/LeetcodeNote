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
    int count = 0;
    public int goodNodes(TreeNode root) {
        recursion(root, root.val);
        return count;
    }
    private void recursion(TreeNode root, int prevMax) {
        if (root == null) {
            return;
        }

        if (root.val >= prevMax) {
            count++;
        }
        recursion(root.left, root.val >= prevMax ? root.val : prevMax);
        recursion(root.right, root.val >= prevMax ? root.val : prevMax);
    }
}