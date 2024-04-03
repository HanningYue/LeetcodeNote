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
        if (sameTree(root, subRoot)) {
            return true;
        }
        
        boolean leftTrue = isSubtree(root.left, subRoot);
        boolean rightTrue = isSubtree(root.right, subRoot);
        return leftTrue || rightTrue;
    }
    private boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean leftSame = sameTree(p.left, q.left);
        boolean rightSame = sameTree(p.right, q.right);
        boolean currentSame = leftSame && rightSame && p.val == q.val;
        return currentSame;
    }
    
}