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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        
        List<List<Integer>> allLevel = new ArrayList<>();
        dfs(root, allLevel, 0);
        for (List<Integer> eachLevel : allLevel) {
            double currentLevelSum = 0;
            for (int i = 0; i < eachLevel.size(); i++) {
                currentLevelSum += eachLevel.get(i);
            }
            result.add(currentLevelSum / eachLevel.size());
        }
        return result;
    }
    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }
}