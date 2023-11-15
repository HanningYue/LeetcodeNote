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
5. In put(), if containsKey, delete old Node, declare Node with new value, add and put.
    If not containsKey, check the capacity, if not exceed, increase count, if exceed
    remove the tail.prev Node in map and delete it from linkedlist
    Declare and put, add new node
*/
class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    int capacity, count;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new Node(0, 0);
        tail = new Node(0 ,0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        map = new HashMap<>();
    }
    
    private void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);
            add(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            delete(map.get(key));
            Node node = new Node(key, value);
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
            add(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */