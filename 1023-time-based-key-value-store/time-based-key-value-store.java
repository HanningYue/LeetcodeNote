class Pair {
    int value;
    String key;
    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<Pair>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        return binarySearch(list, timestamp);
    }
    private String binarySearch(List<Pair> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() == timestamp) {
                return list.get(mid).getKey();
            } else if (list.get(mid).getValue() < timestamp) {
                left = mid + 1;
            } else if (list.get(mid).getValue() > timestamp) {
                right = mid - 1;
            }
        }
        if (right >= 0) {
            return list.get(right).getKey();
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