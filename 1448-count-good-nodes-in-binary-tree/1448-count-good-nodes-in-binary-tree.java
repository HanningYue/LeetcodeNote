/*
1. DFS, any nodes prior to current node should be smaller or equal to the current node's value
2. Maintain a path maximum, DFS to the leaf node, if node val is greater than path maximum, increase the 
   count of Good Nodes and update path maximuim
3. Initialize the DFS function with Integer.MIN_VALUE;
*/
class Solution {
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }
    private void dfs (TreeNode root, int pathMaximum) {
        if (root == null) return;
        if (root.val >= pathMaximum) {
            pathMaximum = root.val;
            goodNodes++;
        }
        dfs(root.left, pathMaximum);
        dfs(root.right, pathMaximum);
    }
}