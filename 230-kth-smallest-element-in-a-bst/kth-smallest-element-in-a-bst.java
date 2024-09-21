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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, k, result);
        return result.get(k - 1);
    }

    private void inorder(TreeNode root, int k, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, result);
        result.add(root.val);
        inorder(root.right, k, result);
    }
}