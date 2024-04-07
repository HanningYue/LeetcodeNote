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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return result;
    }
    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSideMax = oneSideMax(root.left);
        if (leftSideMax < 0) {
            leftSideMax = 0;
        }
        int rightSideMax = oneSideMax(root.right);
        if (rightSideMax < 0) {
            rightSideMax = 0;
        }
        int currentMaxSum = root.val + leftSideMax + rightSideMax;
        result = Math.max(result, currentMaxSum);
        
        int currentOneSidePathSum = Math.max(leftSideMax, rightSideMax) + root.val;
        return currentOneSidePathSum;

    }
}