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
        parentMap.put(root, null);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
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
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }

        while (!set.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }
}