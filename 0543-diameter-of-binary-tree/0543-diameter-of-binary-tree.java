/* Declare private int diameter
1. 向右边要右边的高度 向左边要左边的高度 本层加上+1(本层的高度) 返还给上一层
2. Diameter 每一层比较左右两边加起来 和之前的diameter
3. 主方程call dfs 然后返回diameter
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