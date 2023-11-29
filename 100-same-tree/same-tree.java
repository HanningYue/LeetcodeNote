class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
/*
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();

            if (root1 == null && root2 == null) continue;
            if (root1 == null || root2 == null) return false;
            if (root1.val != root2.val) return false;
            queue.offer(root1.left);
            queue.offer(root2.left);
            queue.offer(root1.right);
            queue.offer(root2.right);
        }
        return true;
    }
}
*/