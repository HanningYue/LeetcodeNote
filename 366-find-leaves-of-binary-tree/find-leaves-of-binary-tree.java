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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return result;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int currentMaxDepth = Math.max(leftDepth, rightDepth) + 1;
        
        if (result.size() < currentMaxDepth) {
            result.add(new ArrayList<>());
        }
        result.get(currentMaxDepth - 1).add(root.val);
        return currentMaxDepth;
    }
}