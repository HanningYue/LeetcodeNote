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
class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode current;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        current = root;
    }
    
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        int value = current.val;
        current = current.right;
        return value;
    }
    
    public boolean hasNext() {
        if (!stack.isEmpty() || current != null) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */