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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }        
        return dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode dfs(int[] postorder, int postleft, int postright, 
    int[] inorder, int inleft, int inright, Map<Integer, Integer> map)
    {
        if (postleft > postright) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postright]);
        int headIdx = map.get(head.val);
        int leftSize = headIdx - inleft;

        head.left = dfs(postorder, postleft, postleft + leftSize - 1, inorder, inleft, headIdx - 1, map);
        head.right = dfs(postorder, postleft + leftSize, postright - 1, inorder, headIdx + 1, inright, map);
        return head;
    }
}

//     1
// 2       3
//     4       5
// postorder [2 4 5 3 1]
// inorder [2 1 4 3 5]