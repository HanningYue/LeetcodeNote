class Node {
    Node prev, next;
    int key, val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Node head, tail;
    Map<Integer, Node> map = new HashMap<>();
    int count = 0, capacity;
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        this.capacity = capacity;
    }
    public void add(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int value = node.val;
        delete(node);
        add(node);
        return value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        } else {
            if (count == capacity) {
                map.remove(tail.prev.key);
                delete(tail.prev);
                count--;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
            count++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */