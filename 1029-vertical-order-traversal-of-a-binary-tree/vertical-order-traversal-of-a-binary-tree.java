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
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> result = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> currentLevelMap = new HashMap<>();
            
            for (int i = 0; i < size; i++) {
                Pair currentPair = queue.poll();
                TreeNode currentNode = currentPair.node;
                int currentCol = currentPair.col;
                
                currentLevelMap.putIfAbsent(currentCol, new ArrayList<>());
                currentLevelMap.get(currentCol).add(currentNode.val);
                
                if (currentNode.left != null) {
                    queue.offer(new Pair(currentNode.left, currentCol - 1));
                }
                
                if (currentNode.right != null) {
                    queue.offer(new Pair(currentNode.right, currentCol + 1));
                }
            }
            
            for (int col : currentLevelMap.keySet()) {
                List<Integer> currentLevelNodeValue = currentLevelMap.get(col);
                Collections.sort(currentLevelNodeValue);
                result.putIfAbsent(col, new ArrayList<>());
                result.get(col).addAll(currentLevelNodeValue);
            }
        }
        
        return new ArrayList<>(result.values());
    }
}
class Pair {
    TreeNode node;
    int col;
    public Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}