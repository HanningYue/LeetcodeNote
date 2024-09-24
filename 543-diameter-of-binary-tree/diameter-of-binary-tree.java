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
    int globalMax = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return globalMax;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        globalMax = Math.max(globalMax, leftMaxDepth + rightMaxDepth);

        int currentMaxDiameter = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return currentMaxDiameter;
    }
}