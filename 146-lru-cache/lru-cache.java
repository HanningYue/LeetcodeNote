class Node {
    Node prev;
    Node next;
    int key;
    int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void add(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int value = node.value;
            delete(node);
            add(node);
            return value;
        }   
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            map.put(key, node);
            delete(node);
            add(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */