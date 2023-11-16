/**
多个value传输 新建一个class TYPE
Type 包含属性：isBalanced和height
1. 检查左边的height，检查右边的height
2. 本层对比左右的math.max height是否绝对值差1
3. isBalanced一定是左.isBalanced 和右.isBalanced 并且高度差绝对值小于1
3. 向上传递一个新的Type是否balanced 以及本层的height
*/
class Solution {
    class Type {
        boolean balanced;
        int height;
        public Type (boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;    
    }
    private Type dfs(TreeNode root) {
        if (root == null) return new Type(true, 0);
        
        Type left = dfs(root.left);
        Type right = dfs(root.right);
        
        boolean balanced = left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        
        return new Type(balanced, height);
    }
}