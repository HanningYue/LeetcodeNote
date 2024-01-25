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
 //上一层*10 + 本层，遇到leaf node 返回当前sum
 //dfs 返回最后的sum
class Solution {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }
    private void dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        pathSum = pathSum * 10 + root.val;
        dfs(root.left, pathSum);
        dfs(root.right, pathSum);
        if (root.left == null && root.right == null) {
            totalSum += pathSum;
        }
    }
}