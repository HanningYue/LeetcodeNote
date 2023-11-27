/**
1. Multiple return value, we need to return
    - whether the tree is balanced (boolean)
    - the height of the tree (int) 
2. Create a seperate class
3. Perform a bottom-up dfs, with ReturnType as return
*/
class Solution {
    class Type {
        int height;
        boolean isBalanced;
        public Type(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    private Type dfs(TreeNode root) {
        if (root == null) {
            return new Type(0, true);
        }

        Type left = dfs(root.left);
        Type right = dfs(root.right);
        
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1);
        return new Type(height, isBalanced);
    }
}