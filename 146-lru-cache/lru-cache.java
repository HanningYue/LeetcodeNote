class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            makeRecent(key);
            return cache.get(key);
        }
        return -1;
    }
    public void makeRecent(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        if (cache.size() >= this.capacity) {
            int leastRecent = cache.keySet().iterator().next();
            cache.remove(leastRecent);
        }
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */