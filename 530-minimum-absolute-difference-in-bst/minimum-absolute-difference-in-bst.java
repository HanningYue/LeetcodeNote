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
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        fill(root);
        int minDiff = Integer.MAX_VALUE;
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            int localDiff = list.get(i + 1) - list.get(i);
            if (localDiff < minDiff) {
                minDiff = localDiff;
            }
        }
        return minDiff;
    }
    private void fill(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            fill(root.left);
            fill(root.right);
        }
    }
}