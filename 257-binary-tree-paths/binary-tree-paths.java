/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }
    private void dfs(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            result.add(new String(path));
        }
        path += "->";
        dfs(root.left, result, path);
        dfs(root.right, result, path);
        path = path.substring(0, path.length() - 1);
    }
}