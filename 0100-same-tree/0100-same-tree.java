/**
1. 左子树是否相同，右子树是否相同
2. 本层对比是否相同
3. 返回左和右都相同
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}