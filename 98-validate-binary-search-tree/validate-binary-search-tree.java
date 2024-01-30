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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    private boolean valid(TreeNode root, TreeNode leftMax, TreeNode rightMin) {
        if (root == null) {
            return true;
        }

        if (leftMax != null && root.val <= leftMax.val) {
            return false;
        } else if (rightMin != null && root.val >= rightMin.val) {
            return false;
        }
        boolean leftTrue = valid(root.left, leftMax, root);
        boolean rightTrue = valid(root.right, root, rightMin);
        boolean bothSideTrue = leftTrue && rightTrue;
        return bothSideTrue;
    }
}