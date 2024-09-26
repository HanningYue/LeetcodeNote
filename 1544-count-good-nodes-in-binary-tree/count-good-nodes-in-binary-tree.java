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
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    private void dfs(TreeNode root, int prevMax) {
        if (root == null) {
            return;
        }
        if (prevMax <= root.val) {
            prevMax = root.val;
            count++;
        }
        dfs(root.left, prevMax);
        dfs(root.right, prevMax);
    }
}