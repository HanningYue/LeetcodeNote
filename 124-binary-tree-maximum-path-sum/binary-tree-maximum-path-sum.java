/**
1. 当前层对比左右 如果小于0 取0
2. 当前max 
*/
class Solution {
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        globalMax = Math.max(globalMax, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}