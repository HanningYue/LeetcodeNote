/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    sb.append("#").append(",");
                } else {
                    sb.append(current.val).append(",");
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] treeNodeArray = data.split(",");
        int index = 1;
        TreeNode root = new TreeNode(Integer.parseInt(treeNodeArray[0]));
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                String left = treeNodeArray[index++];
                if (!left.equals("#")) {
                    current.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(current.left);
                }
                String right = treeNodeArray[index++];
                if (!right.equals("#")) {
                    current.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));