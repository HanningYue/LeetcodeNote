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
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root, null);

        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode current = stack.pop();

            if (current.left != null) {
                stack.push(current.left);
                map.put(current.left, current);
            }
            if (current.right != null) {
                stack.push(current.right);
                map.put(current.right, current);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }

        while (!ancestors.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}