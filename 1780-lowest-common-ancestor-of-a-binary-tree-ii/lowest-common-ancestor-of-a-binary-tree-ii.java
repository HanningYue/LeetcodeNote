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
        boolean pExist = false;
        boolean qExist = false;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == p) {
                    pExist = true;
                }
                if (current == q) {
                    qExist = true;
                }
                if (qExist && pExist) {
                    break;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                    parentMap.put(current.left, current);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    parentMap.put(current.right, current);
                }
            }
        }
        if (!pExist || !qExist) {
            return null;
        }
        Set<TreeNode> parent = new HashSet<>();
        while (p != null) {
            parent.add(p);
            p = parentMap.get(p);
        }
        while (!parent.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }
}