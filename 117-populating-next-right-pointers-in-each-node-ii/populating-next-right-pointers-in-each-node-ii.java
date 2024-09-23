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
        Node previous = null, startOfNextLevel = null;
        while (current != null) {
            while (current != null) {
                
                if (current.left != null && startOfNextLevel == null) {
                    startOfNextLevel = current.left;
                    previous = startOfNextLevel;
                } else if (current.left != null && startOfNextLevel != null) {
                    previous.next = current.left;
                    previous = previous.next;
                }

                if (current.right != null && startOfNextLevel == null) {
                    startOfNextLevel = current.right;
                    previous = startOfNextLevel;
                } else if (current.right != null && startOfNextLevel != null) {
                    previous.next = current.right;
                    previous = previous.next;
                }

                current = current.next;
            }
            
            current = startOfNextLevel;
            startOfNextLevel = null;
            previous = null;
        }
        return root;
    }
}