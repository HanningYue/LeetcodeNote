/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = LCA(root, p, q);
        if (foundP && foundQ) {
            return result;
        }
        return null;
    }

    boolean foundP = false, foundQ = false;
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode leftSub = LCA(root.left, p, q);
        TreeNode rightSub = LCA(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) {
                foundP = true;
            }
            if (root.val == q.val) {
                foundQ = true;
            }
            return root;
        }

        if (leftSub != null && rightSub != null) {
            return root;
        } 

        return leftSub == null ? rightSub : leftSub;
    }
}