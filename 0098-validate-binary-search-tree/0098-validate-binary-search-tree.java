/*
1. Return boolean, we need to check whether 
    The subtree is BST itself
    The current node is greater than the MAXIMUM
2. Need to return multiple values, define a new class TYPE
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    
    public boolean dfs(TreeNode root, Integer leftMaximum, Integer rightMinimum) {
        if (root == null) {
            return true;
        }
        if ((leftMaximum != null && root.val <= leftMaximum) 
            || (rightMinimum != null && root.val >= rightMinimum)) {
            return false;
        }
        boolean leftIsBst = dfs(root.left, leftMaximum, root.val);
        boolean rightIsBst = dfs(root.right, root.val, rightMinimum);
        return leftIsBst && rightIsBst;
    }
}
