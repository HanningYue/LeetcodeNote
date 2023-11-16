/**
1. 向左检查左边的height， 向右检查右边的height
2. 本层对比左右的height是否绝对值差1
3. 向上传递本层是否balanced
*/
class Solution {
    class Type {
        boolean isBalanced;
        int height;
        public Type (boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    private Type dfs(TreeNode root) {
        if (root == null) return new Type(true, 0);
        Type left = dfs(root.left);
        Type right = dfs(root.right);
        boolean isBalanced = left.isBalanced && right.isBalanced 
            && (Math.abs(left.height - right.height) <= 1);
        int height = Math.max(left.height, right.height) + 1;

        return new Type(isBalanced, height);
    }
}