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
                    sb.append(Integer.valueOf(current.val)).append(",");
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }        
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] treeArr = data.split(",");
        int index = 1;
        TreeNode root = new TreeNode(Integer.valueOf(treeArr[0]));        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                String left = treeArr[index++];
                if (!left.equals("#")) {
                    current.left = new TreeNode(Integer.valueOf(left));
                    queue.offer(current.left);
                }

                String right = treeArr[index++];
                if (!right.equals("#")) {
                    current.right = new TreeNode(Integer.valueOf(right));
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