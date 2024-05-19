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
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        stack.push(root);
        parent.put(root, null);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
                parent.put(current.left, current);
            }
            if (current.right != null) {
                stack.push(current.right);
                parent.put(current.right, current);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }
        
        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}