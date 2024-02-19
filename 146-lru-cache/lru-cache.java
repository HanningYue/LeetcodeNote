class Node {
    Node next, prev;
    int key, value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int capacity, count;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        this.capacity = capacity;
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
            delete(node);
            add(node);
            int value = node.value;
            return value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(node);
            delete(node);
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        } 
        else {
            if (count < capacity) {
                count++;
            } else {
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