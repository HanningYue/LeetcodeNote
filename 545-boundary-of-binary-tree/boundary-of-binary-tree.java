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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        dfs(root.left, true, false, result);
        dfs(root.right, false, true, result);
        return result;
    }
    private void dfs(TreeNode root, boolean onLeftBoundary, boolean onRightBoundary, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (onLeftBoundary) {
            result.add(root.val);
        }
        if (!onLeftBoundary && isLeaf(root)) {
            result.add(root.val);
        }
        dfs(root.left, onLeftBoundary && root.left != null, onRightBoundary && root.right == null, result);
        dfs(root.right, onLeftBoundary && root.left == null, onRightBoundary && root.right != null, result);
        if (!onLeftBoundary && !isLeaf(root) && onRightBoundary) {
            result.add(root.val);
        }
    }
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}