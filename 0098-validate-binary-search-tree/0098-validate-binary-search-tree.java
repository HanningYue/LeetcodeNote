/*
1. Return boolean, we need to check whether 
    The subtree is BST itself
    The current node is greater than left child node and smaller than right child node
2. Need to return multiple values, define a new class TYPE
*/
class Solution {
    class ResultType {
        boolean isBST;
        long minValue;
        long maxValue;

        public ResultType(boolean isBST, long minValue, long maxValue) {
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }        
    }
    
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBST;       
    }
    
    private ResultType dfs(TreeNode root) {
        if (root == null) {
            // Using Long.MIN_VALUE and Long.MAX_VALUE to handle edge cases
            return new ResultType(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);

        // Check if both left and right subtrees are BST and their values are within valid range
        if (!left.isBST || !right.isBST || root.val <= left.maxValue || root.val >= right.minValue) {
            return new ResultType(false, 0, 0); // Not a BST
        }
        
        // Calculate the new min and max values for the current subtree
        long minValue = root.left != null ? left.minValue : root.val;
        long maxValue = root.right != null ? right.maxValue : root.val;

        return new ResultType(true, minValue, maxValue);
    }
}