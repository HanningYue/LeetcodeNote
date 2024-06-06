class Node {
    int key, value;
    Node prev, next;
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
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
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
            Node oldNode = map.get(key);
            delete(oldNode);

            oldNode.value = value;
            map.put(key, oldNode);
            add(oldNode);
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