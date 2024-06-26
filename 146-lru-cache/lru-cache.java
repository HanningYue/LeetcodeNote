class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }
    
    public void makeRecent(int key) {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        makeRecent(key);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecent(key);
        } else {
            if (map.size() == capacity) {
                int leastRecent = map.keySet().iterator().next();
                map.remove(leastRecent);
            }
            map.put(key, value);
            makeRecent(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */