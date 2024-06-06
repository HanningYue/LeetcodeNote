class Node {
    int key, value;
    Node prev, next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 9);
        head.next = tail;
        tail.prev = head;
    }
    
    public void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void add(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int value = node.value;
        delete(node);
        add(node);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);

            node.value = value;
            map.put(key, node);
            add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */