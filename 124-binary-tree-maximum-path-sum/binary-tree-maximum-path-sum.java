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
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathMax(root);
        return globalMax;
    }
    private int pathMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = pathMax(root.left);
        if (leftMax < 0) {
            leftMax = 0;
        }

        int rightMax = pathMax(root.right);
        if (rightMax < 0) {
            rightMax = 0;
        }

        int currentMax = Math.max(leftMax, rightMax) + root.val;
        globalMax = Math.max(globalMax, leftMax + rightMax + root.val);
        return currentMax;
    }
}