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
    List<Integer> result = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        result.add(root.val);
        dfs(root.left, true, false);
        dfs(root.right, false, true);
        return result;
    }
    private void dfs(TreeNode root, boolean leftBoundary, boolean rightBoundary) {
        if (root == null) {
            return;
        }
        if (leftBoundary) {
            result.add(root.val);
        }
        if (isLeaf(root) && !leftBoundary) {
            result.add(root.val);
        }
        
        dfs(root.left, leftBoundary && root.left != null, rightBoundary && root.right == null);
        dfs(root.right, leftBoundary && root.left == null, rightBoundary && root.right != null);

        if (rightBoundary && !leftBoundary && !isLeaf(root)) {
            result.add(root.val);
        }
    }
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}