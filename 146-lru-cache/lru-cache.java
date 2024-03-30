class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;
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
            makeRecent(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecent(key);
            return;
        }
        else if (!map.containsKey(key)) {
            if (map.size() >= this.capacity) {
                int leastRecent = map.keySet().iterator().next();
                map.remove(leastRecent);
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