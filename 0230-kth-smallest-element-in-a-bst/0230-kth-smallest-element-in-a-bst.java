/**
1. Since it is a BST, the left most TreeNode is the smallest
2. Use recursion inorder, save the tree into a list of Integer, since in-order, save the 
    left-most leaf node first, then the (left-most - 1) leaf node next.....
    If want the kth smallest element, simply return list.get(k - 1) since 1-indexed.
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result.get(k - 1);
    }
    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}