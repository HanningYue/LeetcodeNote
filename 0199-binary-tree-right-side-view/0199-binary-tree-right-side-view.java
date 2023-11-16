class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        
        if (result.size() == level) {
            result.add(root.val);
        }
        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);
    }
}