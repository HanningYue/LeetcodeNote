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
class State {
    TreeNode root;
    int currentMax;
    public State(TreeNode root, int currentMax) {
        this.root = root;
        this.currentMax = currentMax;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        int count = 1;
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(root, root.val));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                if (current.root.left != null) {
                    if (current.root.left.val >= current.currentMax) {
                        queue.offer(new State(current.root.left, current.root.left.val));
                        count++;
                    } else {
                        queue.offer(new State(current.root.left, current.currentMax));
                    }
                }

                if (current.root.right != null) {
                    if (current.root.right.val >= current.currentMax) {
                        queue.offer(new State(current.root.right, current.root.right.val));
                        count++;
                    } else {
                        queue.offer(new State(current.root.right, current.currentMax));
                    }
                }
            }
        }
        return count;
    }
}