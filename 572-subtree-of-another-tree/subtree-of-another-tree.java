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
        if (root == null) {
            return false;
        }
        if (sameTree(root, subRoot)) {
            return true;
        }
        boolean leftSub = isSubtree(root.left, subRoot);
        boolean rightSub = isSubtree(root.right, subRoot);
        return leftSub || rightSub;
    }
    private boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        boolean currentSame = p.val == q.val;
        boolean leftSame = sameTree(p.left, q.left);
        boolean rightSame = sameTree(p.right, q.right);
        return currentSame && rightSame && leftSame;
    }
}