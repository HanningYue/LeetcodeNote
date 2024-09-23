/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        parentMap.put(root, null);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
        
        Set<TreeNode> parents = new HashSet<>();
        while (p != null) {
            parents.add(p);
            p = parentMap.get(p);
        }
        while (!parents.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }
}