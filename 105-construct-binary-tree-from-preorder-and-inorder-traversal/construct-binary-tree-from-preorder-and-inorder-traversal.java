/**
1. Map {Index value of inorder, index of inorder}, traverse inorder array, fill inOrderMap
2. construct helper method, recursion call the root.left and root.right
3. The exit rule if the index inleft is > inright
4. int mid is the corresponding inorder array root index
5. Be careful with the boundary while writing the recursion, the side with root node index*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }
    private TreeNode dfs(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright, 
    Map<Integer, Integer> inMap)
    {
        if (preleft > preright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        int mid = inMap.get(root.val);
        root.left = dfs(preorder, preleft + 1, preleft + mid - inleft, inorder, inleft, mid - 1, inMap);
        root.right = dfs(preorder, preleft + mid - inleft + 1, preright, inorder, mid + 1, inright, inMap);
        return root;
    }
}