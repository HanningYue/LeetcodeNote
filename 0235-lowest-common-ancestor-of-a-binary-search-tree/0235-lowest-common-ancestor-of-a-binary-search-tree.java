/**
因为是BST，我们从root node出发的话 左边都小于rootnode 右边都大于rootnode
dfs, 如果当前root value小于p并且小于q -> 查找当前root右边 root.right
     如果当前root value大于p并且大于q -> 查找当前root左边 root.left

q和p 要么都大于root 要么都小于root 要么一大一小
如果一大一小那么当前的root一定是他们的lowest common ancestor
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}