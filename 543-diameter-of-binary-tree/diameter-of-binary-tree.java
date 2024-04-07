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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDep = maxDepth(root.left);
        int rightMaxDep = maxDepth(root.right);
        int currentMaxDep = Math.max(leftMaxDep, rightMaxDep) + 1;

        result = Math.max(result, leftMaxDep + rightMaxDep);
        return currentMaxDep;
    }
}