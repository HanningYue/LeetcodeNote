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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = -1, maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode newRoot = new TreeNode(maxVal);
        newRoot.left = build(nums, left, maxIndex - 1);
        newRoot.right = build(nums, maxIndex + 1, right);
        return newRoot;
    }
}