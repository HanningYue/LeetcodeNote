class Solution {
    public int goodNodes(TreeNode root) {
        int[] count = {0};
        dfs(root, Integer.MIN_VALUE, count);
        return count[0];
    }
    private void dfs(TreeNode root, int pathMax, int[] count) {
        if (root == null) return;
        if (root.val >= pathMax) {
            count[0]++;
            pathMax = root.val;
        }
        dfs(root.left, pathMax, count);
        dfs(root.right, pathMax, count);
    }
}