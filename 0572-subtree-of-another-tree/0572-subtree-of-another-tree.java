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
        if (sameTree(root, subRoot)) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        boolean subLeft = isSubtree(root.left, subRoot);
        boolean subRight = isSubtree(root.right, subRoot);
        return subLeft || subRight;
    }
    
    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }    
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        boolean leftSame = sameTree(root.left, subRoot.left);
        boolean rightSame = sameTree(root.right, subRoot.right);
        return leftSame && rightSame;
    }
}