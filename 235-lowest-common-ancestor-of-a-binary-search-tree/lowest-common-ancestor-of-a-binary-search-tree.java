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
        TreeNode parent = root;
        while (parent != null) {
            int parentVal = parent.val;
            if (p.val > parentVal && q.val > parentVal) {
                parent = parent.right;
            } else if (p.val < parentVal && q.val < parentVal) {
                parent = parent.left;
            } else {
                return parent;
            }
        }
        return null;
    }
}