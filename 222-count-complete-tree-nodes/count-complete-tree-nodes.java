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

        int leftHeight = 0, rightHeight = 0;
        TreeNode currentLeft = root;
        TreeNode currentRight = root;
        while (currentLeft != null) {
            currentLeft = currentLeft.left;
            leftHeight++;
        }
        while (currentRight != null) {
            currentRight = currentRight.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }
        return countNode(root);
    }

    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSub = countNode(root.left);
        int rightSub = countNode(root.right);
        return leftSub + rightSub + 1;
    }
}