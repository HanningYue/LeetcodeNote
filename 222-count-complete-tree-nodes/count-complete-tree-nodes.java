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
        TreeNode traverseLeft = root;
        while (traverseLeft.left != null) {
            leftHeight++;
            traverseLeft = traverseLeft.left;
        }

        int rightHeight = 1;
        TreeNode traverseRight = root;
        while (traverseRight.right != null) {
            rightHeight++;
            traverseRight = traverseRight.right;
        }

        if (rightHeight == leftHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        return notPerfect(root);
    }
    private int notPerfect(TreeNode root) {
        int nodeInLeftSub = countNodes(root.left);
        int nodeInRightSub = countNodes(root.right);
        int countInCurrent = nodeInLeftSub + nodeInRightSub + 1;
        return countInCurrent;
    }
}