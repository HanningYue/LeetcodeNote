class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.random = copyRandomList(head.random);
        newHead.next = copyRandomList(head.next);
        return newHead;
    }
}