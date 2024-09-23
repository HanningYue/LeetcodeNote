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
    int column;
    TreeNode node;
    public State(int column, TreeNode node) {
        this.column = column;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                int currentCol = current.column;
                TreeNode currentNode = current.node;

                if (currentNode.left != null) {
                    queue.offer(new State(currentCol - 1, currentNode.left));
                }
                if (currentNode.right != null) {
                    queue.offer(new State(currentCol + 1, currentNode.right));
                }

                levelMap.putIfAbsent(currentCol, new ArrayList<>());
                levelMap.get(currentCol).add(currentNode.val);
            }

            for (int column : levelMap.keySet()) {
                treeMap.putIfAbsent(column, new ArrayList<>());
                List<Integer> values = levelMap.get(column);
                Collections.sort(values);
                for (int value : values) {
                    treeMap.get(column).add(value);
                }
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}