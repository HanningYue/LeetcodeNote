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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 1;
        TreeNode leftCopy = root;
        while (leftCopy.left != null) {
            leftHeight++;
            leftCopy = leftCopy.left;
        }

        int rightHeight = 1;
        TreeNode rightCopy = root;
        while (rightCopy.right != null) {
            rightHeight++;
            rightCopy = rightCopy.right;
        }

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        return notPerfect(root);
    }
    private int notPerfect(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = notPerfect(root.left);
        int rightCount = notPerfect(root.right);
        int totalCount = leftCount + rightCount + 1;
        return totalCount;
    }
}