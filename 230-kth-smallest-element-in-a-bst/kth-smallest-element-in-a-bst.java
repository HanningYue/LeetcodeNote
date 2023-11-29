/**
1. We want the kth smallest TreeNode in a Binary Search Tree. Since it is a BST, the left most TreeNode is the smallest
2. Follow the above property, use recursion inorder, save the tree into a list of Integer
3. Return list.get(k - 1) since the kth is 1-indexed
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result.get(k - 1);
    }
    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}