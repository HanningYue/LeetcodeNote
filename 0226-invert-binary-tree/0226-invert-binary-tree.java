/**
1. Use a copy node
2. Recursion
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode node = new TreeNode(root.val);
        node.val = root.val;
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
    }
}