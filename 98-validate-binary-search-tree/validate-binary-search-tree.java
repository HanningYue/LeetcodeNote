/**
1. DFS, take TreeNode current, Integer min for left subtree, Integer max for right subtree
2. Apply null value for min and max value in main function
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && (root.val <= min) || (max != null && (root.val >= max))) {
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}