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
        StringBuilder sb = new StringBuilder();
        se(root, sb);
        return sb.toString();
    }
    private void se(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        se(root.left, sb);
        se(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        int[] index = new int[]{0};
        return de(tree, index);
    }
    private TreeNode de(String[] tree, int[] index) {
        if (tree[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        int value = Integer.parseInt(tree[index[0]]);
        TreeNode root = new TreeNode(value);
        index[0]++;
        root.left = de(tree, index);
        root.right = de(tree, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));