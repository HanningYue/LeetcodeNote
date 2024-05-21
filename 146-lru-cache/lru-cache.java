class Node {
    Node prev, next;
    int key, value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();    
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void delete(Node node) {
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
            Node oldNode = map.get(key);
            delete(oldNode);
   
            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() >= capacity) {
                int lruKey = tail.prev.key;
                Node lruNode = tail.prev;

                delete(lruNode);
                map.remove(lruKey);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */