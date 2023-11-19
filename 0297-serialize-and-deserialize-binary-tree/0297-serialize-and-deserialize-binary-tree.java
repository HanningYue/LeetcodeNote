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
    String endMarker = "#";
    String spliter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        se(root, sb);
        return sb.toString();
    }
    private void se(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(endMarker).append(spliter);
            return;
        }
        sb.append(root.val).append(spliter);
        se(root.left, sb);
        se(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        return de(tree);
    }
    private TreeNode de(String[] tree) {
        if (index == tree.length) {
            return null;
        }
        if (tree[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(tree[index]));
        index++;
        root.left = de(tree);
        root.right = de(tree);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));