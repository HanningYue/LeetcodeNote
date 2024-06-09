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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currentCol = current.col;
                TreeNode currentNode = current.node;

                map.putIfAbsent(currentCol, new ArrayList<>());
                map.get(currentCol).add(currentNode.val);

                if (currentNode.left != null) queue.offer(new Pair(currentNode.left, currentCol - 1));
                if (currentNode.right != null) queue.offer(new Pair(currentNode.right, currentCol + 1));
            }

            for (int col : map.keySet()) {
                List<Integer> columnNode = map.get(col);
                Collections.sort(columnNode);
                treeMap.putIfAbsent(col, new ArrayList<>());
                treeMap.get(col).addAll(columnNode);
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}
class Pair {
    TreeNode node;
    int col;
    public Pair(TreeNode node, int col) {
        this.col = col;
        this.node = node;
    }
}