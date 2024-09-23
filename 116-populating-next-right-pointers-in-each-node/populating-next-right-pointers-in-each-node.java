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
        Node current = root;
        
        Node nextLevelStart = null, previous = null;
        while (current != null) {
            
            while (current != null) {
                if (current.left != null) {
                    if (nextLevelStart == null) {
                        nextLevelStart = current.left;
                        previous = current.left;
                    } else {
                        previous.next = current.left;
                        previous = previous.next;
                    }
                }

                if (current.right != null) {
                    if (nextLevelStart == null) {
                        nextLevelStart = current.right;
                        previous = current.right;
                    } else {
                        previous.next = current.right;
                        previous = previous.next;
                    }
                }

                current = current.next;
            }

            current = nextLevelStart;
            previous = null;
            nextLevelStart = null;
        }
        return root;
    }
}