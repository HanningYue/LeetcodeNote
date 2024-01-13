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
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.next = null;
        tail.prev = head;
        head.prev = null;
        count = 0;
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