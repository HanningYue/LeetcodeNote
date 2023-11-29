/**
1. want to check if the subRoot is the same tree in current root
2. helper method, isSameTree
3. in current tree, check if subRoot is null OR root, subRoot isSameTree
    and check case when only one root is
4. check root.left and root.right
*/
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (sameTree(root, subRoot)) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean leftSame = sameTree(root1.left, root2.left);
        boolean rightSame = sameTree(root1.right, root2.right);
        boolean currentSame = root1.val == root2.val;
        return leftSame && rightSame && currentSame;
    }
}