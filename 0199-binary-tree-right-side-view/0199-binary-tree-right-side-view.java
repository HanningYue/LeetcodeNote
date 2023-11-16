class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode rightMost = queue.poll();
                if (i == size - 1) {
                    result.add(rightMost.val);
                }
                if (rightMost.left != null) {
                    queue.offer(rightMost.left);
                }
                if (rightMost.right != null) {
                    queue.offer(rightMost.right);
                } 
            }
        }
        return result;
    }
}