/**
1. 需要左边的max和0对比 需要右边的max和0对比
2. 本层返回本层node加上 左右两边更大的呢一边
3. globalMax需要每一层都更新 和本层加左加右对比
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