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

        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        
        Node copyNext = copyRandomList(head.next);
        copyHead.next = copyNext;
        
        Node copyRandom = copyRandomList(head.random);
        copyHead.random = copyRandom;

        return copyHead;
        
    }
}