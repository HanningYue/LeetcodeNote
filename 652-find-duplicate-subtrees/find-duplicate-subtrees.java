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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>(); //{path, frequency}
        List<TreeNode> result = new ArrayList<>();
        traverse(root, map, result);
        return result;
    }
    private String traverse(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return null;
        }

        String left = traverse(root.left, map, result);
        String right = traverse(root.right, map, result);

        String path = root.val + "," + left + "," + right;
        int freq = map.getOrDefault(path, 0);
        if (freq == 1) {
            result.add(root);
        }   

        map.put(path, map.getOrDefault(path, 0) + 1);
        return path;
    }
}