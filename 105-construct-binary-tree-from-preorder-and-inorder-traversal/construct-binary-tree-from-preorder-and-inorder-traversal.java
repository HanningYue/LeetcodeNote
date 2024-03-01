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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode dfs(int[] preorder, int preleft, int preright, 
    int[] inorder, int inleft, int inright, Map<Integer, Integer> map) 
    {
        if (preleft > preright) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preleft]);
        int headIdx = map.get(head.val);
        int leftSize = headIdx - inleft;

        head.left = dfs(preorder, preleft + 1, preleft + leftSize, inorder, inleft, headIdx - 1, map);
        head.right = dfs(preorder, preleft + leftSize + 1, preright, inorder, headIdx + 1, inright, map);
        return head;
    }
}
//     1
// 2       3
//     4       5
// preorder[1 2 3 4 5]
// inorder[2 1 4 3 5]
// head 1
// left 2
// right 4 3 5