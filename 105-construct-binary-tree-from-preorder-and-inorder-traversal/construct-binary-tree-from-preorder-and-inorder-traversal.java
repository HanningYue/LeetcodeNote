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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int preleft, int preright, 
    int[] inorder, int inleft, int inright)
    {
        if (preleft > preright) {
            return null;
        }

        int headValue = preorder[preleft];
        int headIndex = map.get(headValue);
        int leftSubtreeSize = headIndex - inleft;
        
        TreeNode root = new TreeNode(headValue);
        
        root.left = recursion(preorder, preleft + 1, preleft + leftSubtreeSize, 
        inorder, inleft, headIndex - 1);
        
        root.right = recursion(preorder, preleft + leftSubtreeSize + 1, preright, 
        inorder, headIndex + 1, inright);
        
        return root;
    }
}
/**
3 9 20 15 7
9 3 15 20 7
0 1  2  3 4
*/