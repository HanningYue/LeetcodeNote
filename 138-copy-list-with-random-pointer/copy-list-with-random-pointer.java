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

        Node current = head;
        Node copy = new Node(current.val, null, null);
        map.put(current, copy);

        while (current != null) {
            copy.random = createCopy(current.random);
            copy.next = createCopy(current.next);

            copy = copy.next;
            current = current.next;
        }
        return map.get(head);
    }

    private Node createCopy(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val, null, null);
        map.put(node, copy);
        return map.get(node);
    }
}