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
        
        int leftHeight = 1, rightHeight = 1;
        TreeNode goLeft = root;
        while (goLeft.left != null) {
            goLeft = goLeft.left;
            leftHeight++;
        }

        TreeNode goRight = root;
        while (goRight.right != null) {
            goRight = goRight.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, rightHeight) - 1;
        }

        return notPerfect(root);
    }
    private int notPerfect(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSub = notPerfect(root.left);
        int rightSub = notPerfect(root.right);
        int currentNum = leftSub + rightSub + 1;
        return currentNum;
    }
}