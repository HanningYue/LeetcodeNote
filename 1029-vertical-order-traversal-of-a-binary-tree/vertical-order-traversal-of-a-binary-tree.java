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
class Pair {
    TreeNode node;
    int col;
    public Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair currentPair = queue.poll();
                TreeNode currentNode = currentPair.node;
                int currentCol = currentPair.col;

                map.putIfAbsent(currentCol, new ArrayList<>());
                map.get(currentCol).add(currentNode.val);

                if (currentNode.left != null) queue.offer(new Pair(currentNode.left, currentCol - 1));
                if (currentNode.right != null) queue.offer(new Pair(currentNode.right, currentCol + 1));
            }

            for (int col : map.keySet()) {
                List<Integer> colNode = map.get(col);
                Collections.sort(colNode);
                treeMap.putIfAbsent(col, new ArrayList<>());
                for (int nodeValue : colNode) {
                    treeMap.get(col).add(nodeValue);
                }
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}