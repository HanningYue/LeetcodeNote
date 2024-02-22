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
        return dfs(root, p, q);
    }
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) { //return the possible descendant subTree
        if (root == null) {
            return null;
        }
//Scenario 1, current root is either p or q
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
//Scenario2, current root is the parent of p and q, why &&? 
//because if one node is the parent of another, we back to scenario 1
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}