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
/**
周长，如果是最长，那么一定是leaf
递归，向左向右要最深的高度，加上1（当前层高度）
每次递归 更新最大周长
 */
class Solution {
    int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}