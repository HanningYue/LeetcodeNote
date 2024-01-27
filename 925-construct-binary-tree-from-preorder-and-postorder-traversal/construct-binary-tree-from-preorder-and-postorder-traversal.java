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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode build(int[] preorder, int preleft, int preright, 
    int[] postorder, int postleft, int postright, Map<Integer, Integer> map)
    {
        if (preleft > preright) {
            return null;
        }
        if (preleft == preright) {
            return new TreeNode(preorder[preleft]);
        }
        
        int startOfLeft = preorder[preleft + 1];
        int startOfLeftIdx = map.get(startOfLeft);
        int leftSize = startOfLeftIdx - postleft + 1;

        TreeNode head = new TreeNode(preorder[preleft]);
        head.left = build(preorder, preleft + 1, preleft + leftSize, 
        postorder, postleft, startOfLeftIdx, map);

        head.right = build(preorder, preleft + leftSize + 1, preright,
        postorder, startOfLeftIdx + 1, postright - 1, map);
        
        return head;
    }
}