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
        if (root == null || subRoot == null) {
            return false;
        }
        if (sameTree(root, subRoot)) {
            return true;
        }
        boolean leftSubIsSame = isSubtree(root.left, subRoot);
        boolean rightSubIsSame = isSubtree(root.right, subRoot);
        return leftSubIsSame || rightSubIsSame;
    }
    private boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean currentSame = p.val == q.val;
        boolean leftSame = sameTree(p.left, q.left);
        boolean rightSame = sameTree(p.right, q.right);
        return currentSame && leftSame && rightSame;
    }
}