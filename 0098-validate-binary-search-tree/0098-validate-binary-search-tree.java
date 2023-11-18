/*
1. Return boolean, we need to check whether 
    The subtree is BST itself
    The current node is greater than left child node and smaller than right child node
2. Need to return multiple values, define a new class TYPE
*/
class Solution {
    class Type {
        boolean isBST;
        long min;
        long max;
        public Type(boolean isBST, long min, long max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }        
    }
    
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBST;       
    }
    
    private Type dfs(TreeNode root) {
        if (root == null) {
            return new Type(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        Type left = dfs(root.left);
        Type right = dfs(root.right);

        if (!left.isBST || !right.isBST || root.val <= left.max || root.val >= right.min) {
            return new Type(false, 0, 0);
        }
        
        long min = root.left != null ? left.min : root.val;
        long max = root.right != null ? right.max : root.val;

        return new Type(true, min, max);
    }
}