/*
用DFS的方法解决这道问题
对于每一个node的next和random node
用recursion call original function
return copy of each node
*/
class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) {
            return map.get(head);
        }    
        
        Node copy = new Node(head.val);
        map.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
    }
}