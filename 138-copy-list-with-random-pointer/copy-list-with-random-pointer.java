/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node copy = new Node(head.val);
        map.put(head, copy);
        
        Node current = head;
        while (current != null) {
            copy.random = createCopy(current.random);
            copy.next = createCopy(current.next);

            current = current.next;
            copy = copy.next;
        }
        return map.get(head);
    }

    private Node createCopy(Node node) {
        if (node != null) {
            if (map.containsKey(node)) {
                return map.get(node);
            } else {
                Node copy = new Node(node.val, null, null);
                map.put(node, copy);
                return copy;
            }
        }
        return null;
    }
}