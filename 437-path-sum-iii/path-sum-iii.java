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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>(); //currentPathSum, previousPathSum
        return dfs(root, targetSum, map, 0l);
    }
    private int dfs(TreeNode root, int targetSum, Map<Long, Integer> map, Long prefixSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        prefixSum += root.val;
        if (prefixSum == targetSum) {
            count++;
        }
        count += map.getOrDefault(prefixSum - targetSum, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += dfs(root.left, targetSum, map, prefixSum);
        count += dfs(root.right, targetSum, map,prefixSum);
        
        map.put(prefixSum, map.getOrDefault(prefixSum, 1) - 1);
        return count;
    }
}