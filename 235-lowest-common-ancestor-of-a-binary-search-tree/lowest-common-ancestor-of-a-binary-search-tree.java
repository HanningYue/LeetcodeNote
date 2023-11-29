/**
1. Because this is a binary search tree, the desired node must be greater than its left child node and also less than its right child node
2. So three situations, 
    if greater than both p and q, recursion check root.left.because root.left < root 
    if less than both p and q, recursion check root.right. because root.right > root
    return desired root if it is the TreeNode itself or it is the right father TreeNode
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}