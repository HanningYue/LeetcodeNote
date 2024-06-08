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

        TreeNode leftPath = lowestCommonAncestor(root.left, p, q);
        TreeNode rightPath = lowestCommonAncestor(root.right, p, q);
        if (root != null && leftPath != null && rightPath != null) {
            return root;
        }
        
        if (leftPath == null) {
            return rightPath;
        } else if (rightPath == null) {
            return leftPath;
        } else {
            return null;
        }
    }
}