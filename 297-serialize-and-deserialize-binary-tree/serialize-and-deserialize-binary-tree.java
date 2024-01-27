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

    // Encodes a tree to a single string.
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
                    continue;
                }
                sb.append(current.val).append(",");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] node = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode parent = queue.poll();
                String left = node[index++];
                if (!left.equals("#")) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(parent.left);
                }
                String right = node[index++];
                if (!right.equals("#")) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(parent.right);
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