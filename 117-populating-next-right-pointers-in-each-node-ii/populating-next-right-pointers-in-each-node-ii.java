/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node current = root, head = null, prev = null;
        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    if (head == null) {
                        head = current.left;
                        prev = current.left;
                    } else {
                        prev.next = current.left;
                        prev = prev.next;
                    }
                }
                if (current.right != null) {
                    if (head == null) {
                        head = current.right;
                        prev = current.right;
                    } else {
                        prev.next = current.right;
                        prev = prev.next;
                    }
                }
                current = current.next;
            }
            current = head;
            head = null;
            prev = null;
        }
        return root;
    }
}