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
        int pathMax = root.val;
        dfs(root, pathMax);
        return count;
    }
    private void dfs(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }
        if (root.val >= pathMax) {
            count++;
            pathMax = root.val;
        }
        dfs(root.left, pathMax);
        dfs(root.right, pathMax);
    }
}