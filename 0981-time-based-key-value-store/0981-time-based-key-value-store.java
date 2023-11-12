/*
We need to use a map for relation of key and timestamp 
    and a Pair for value of timestamp and timestamp
Map<String, List<Pair<String, Integer>>>
    key                value  timestamp
When Binary search, 求右边界
*/
class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<String, Integer>> list = map.get(key);
        return binarySearch(list, timestamp);
    }
    public String binarySearch(List<Pair<String, Integer>> list, int timestamp) {
        int low = 0, high = list.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (list.get(mid).getValue() == timestamp) {
                return list.get(mid).getKey();
            } else if (list.get(mid).getValue() > timestamp) {
                high = mid - 1;
            } else if (list.get(mid).getValue() < timestamp) {
                low = mid + 1;
            }
        }
        
        if (high >= 0 && list.get(high).getValue() <= timestamp) {
            return list.get(high).getKey();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */