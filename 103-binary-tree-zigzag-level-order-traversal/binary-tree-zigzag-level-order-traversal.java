/*
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        int level = 0;
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level == 0) {
                    TreeNode current = deque.pollLast();
                    currentLevel.add(current.val);
                    if (current.left != null) deque.offerFirst(current.left);
                    if (current.right != null) deque.offerFirst(current.right);
                } else {
                    TreeNode current = deque.pollFirst();
                    currentLevel.add(current.val);
                    if (current.right != null) deque.offerLast(current.right);
                    if (current.left != null) deque.offerLast(current.left);
                }
            }
            level = 1 - level;
            result.add(currentLevel);
        }
        return result;
    }
}
*/
class Solution {
	public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level == 0) {
                    TreeNode current = deque.pollLast();
                    if (current.left != null) deque.offerFirst(current.left);
                    if (current.right != null) deque.offerFirst(current.right);
                    list.add(current.val);
                } else {
                    TreeNode current = deque.pollFirst();
                    if (current.right != null) deque.offerLast(current.right);
                    if (current.left != null) deque.offerLast(current.left);
                    list.add(current.val);
                }
            }
            level = 1 - level;
            result.add(list);
        }
        return result;
    }
}