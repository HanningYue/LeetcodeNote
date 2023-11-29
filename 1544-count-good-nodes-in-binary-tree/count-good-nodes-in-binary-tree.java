/**
1. We want to return the total number of good nodes, create a reference variable
2. we need to compare the current level node value with the previous path max 
3. if the current node value is greater, we need to update the previous path max*/
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    private void dfs(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }
        if (root.val >= pathMax) {
            pathMax = root.val;
            count++;
        }
        dfs(root.left, pathMax);
        dfs(root.right, pathMax);
    }
}