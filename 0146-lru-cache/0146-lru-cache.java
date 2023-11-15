/*
1.delete(), add(), get(), put()
2. Create a Node class, use a linkedlist node. 
    Which contains key, value, prev and next pointer Node
    Use map to store {key, node}. A capacity and count to keep track of size of linkedlist
    And head and tail Node to declare linkedlist
3. Construct linkedlist in LRUCache(), implement delete and add function
    When adding, make sure to add node to the next of head. Because we need to keep up 
    with the most recently used key
4. In get(), if containsKey, delete first, then add again (to update recently), 
    return the Node value
5. In put(), if 

*/
class LRUCache {
    
    class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    Node head, tail;
    int capacity, count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.next = null;
        tail.prev = head;
        head.prev = null;
        count = 0;
    }
    private void delete (Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void add (Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            delete(map.get(key));
            add(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = new Node(key, value);
            delete(map.get(key));
            map.put(key, node);
            add(node);
        } else {
            if (count < capacity) {
                count++;
            } else {
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }
}
