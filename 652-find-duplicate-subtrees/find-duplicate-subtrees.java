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
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }
    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        String myself = left + " " + right + " " + root.val;
        
        int frequency = map.getOrDefault(myself, 0);
        if (frequency == 1) {
            result.add(root);
        }
        map.put(myself, frequency + 1);
        return myself;
    }
}