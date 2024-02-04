class Node {
    Node prev, next;
    int key, value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    Node head, tail;
    int capacity, count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    
    public void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
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
            delete(map.get(key));

            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
        else if (!map.containsKey(key)) {
            if (count < capacity) {
                count++;
            } else if (count >= capacity) {
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