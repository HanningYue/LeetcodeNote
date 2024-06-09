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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        boolean even = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (even) {
                    TreeNode current = deque.pollLast();
                    if (current.left != null) deque.offerFirst(current.left);
                    if (current.right != null) deque.offerFirst(current.right);
                    currentLevel.add(current.val);
                } else {
                    TreeNode current = deque.pollFirst();
                    if (current.right != null) deque.offerLast(current.right);
                    if (current.left != null) deque.offerLast(current.left);
                    currentLevel.add(current.val);
                }
            }
            even = !even;
            result.add(currentLevel);
        }
        return result;
    }
}