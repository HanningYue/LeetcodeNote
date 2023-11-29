class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, 0, root);
        return result;
    }
    private void dfs(List<Integer> result, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        }
        dfs(result, level + 1, root.right);
        dfs(result, level + 1, root.left);
    }
}