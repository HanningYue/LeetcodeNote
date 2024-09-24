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
        diameter(root);
        return globalMax;
    }
    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSub = diameter(root.left);
        int rightSub = diameter(root.right);
        int currentMax = Math.max(leftSub, rightSub) + 1;
        globalMax = Math.max(globalMax, leftSub + rightSub);
        return currentMax;
    }
}