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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        boolean leftSub = isSubtree(root.left, subRoot);
        boolean rightSub = isSubtree(root.right, subRoot);
        return leftSub || rightSub || isSame(root, subRoot);
    }
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        boolean currentSame = p.val == q.val;
        boolean leftSame = isSame(p.left, q.left);
        boolean rightSame = isSame(p.right, q.right);
        return currentSame && leftSame && rightSame;
    }
}