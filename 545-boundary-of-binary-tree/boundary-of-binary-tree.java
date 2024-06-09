class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        addLeftBoundary(root.left);
        addLeaves(root);
        addRightBoundary(root.right);
        return result;
    }
    
    private void addLeftBoundary(TreeNode node) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
    
    private void addLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            result.add(node.val);
        } else {
            addLeaves(node.left);
            addLeaves(node.right);
        }
    }
    
    private void addRightBoundary(TreeNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
