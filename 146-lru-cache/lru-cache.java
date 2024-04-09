class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public void makeRecent(int key) {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            makeRecent(key);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecent(key);
        } else {
            if (map.size() >= capacity) {
                int leastRecentKey = map.keySet().iterator().next();
                map.remove(leastRecentKey);
            }
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */