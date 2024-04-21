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
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }

        int root = preorder[preleft];
        int rootIndex = inMap.get(root);
        int leftSubTreeSize = rootIndex - inleft;

        TreeNode newRoot = new TreeNode(root);
        newRoot.left = build(preorder, preleft + 1, preleft + leftSubTreeSize, inorder, inleft, rootIndex - 1);
        newRoot.right = build(preorder, preleft + leftSubTreeSize + 1, preright, inorder, rootIndex + 1, inright);
        return newRoot;
    }
}
/**
        1
    2       3
4    5    6    7
4 2 5 1 6 3 7
1 2 4 5 3 6 7
0 1 2 3 4 5 6
3

*/