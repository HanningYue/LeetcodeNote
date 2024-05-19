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
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftSub = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSub = lowestCommonAncestor(root.right, p, q);
        if (leftSub != null && rightSub != null) {
            return root;
        } else if (leftSub == null) {
            return rightSub;
        } else {
            return leftSub;
        }
    }
}