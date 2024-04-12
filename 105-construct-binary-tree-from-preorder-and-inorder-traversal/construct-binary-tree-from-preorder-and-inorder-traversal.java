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
        return dfs(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(Map<Integer, Integer> map, int[] preorder, int preleft, int preright, 
    int[] inorder, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        
        int headVal = preorder[preleft];
        int midIndex = map.get(headVal);
        int leftSize = midIndex - inleft;

        TreeNode newHead = new TreeNode(headVal);
        newHead.left = dfs(map, preorder, preleft + 1, preleft + leftSize, inorder, inleft, midIndex - 1);
        newHead.right = dfs(map, preorder, preleft + leftSize + 1, preright, inorder, midIndex + 1, inright);
        return newHead;
    }
}
/**
3 9 20 15 7
9 3 15 20 7
0 1  2  3 4
*/