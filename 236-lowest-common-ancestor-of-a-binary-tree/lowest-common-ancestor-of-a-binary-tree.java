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
        return find(root, p, q);
    }
    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode findLeft = find(root.left, p, q);
        TreeNode findRight = find(root.right, p, q);
        if (findLeft != null && findRight != null) {
            return root;
        }
        return findLeft != null ? findLeft : findRight;
    }
}