/*
1. 向右边要最大的diameter 向左边要最大的diameter
2. 本层比较左右两边的diameter 加上自己的level +1
3. 返回本层加1后的level到上一层
*/
class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}