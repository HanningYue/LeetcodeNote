class Pair {
    String value;
    int timestamp;
    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
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

    public String binarySearch(List<Pair> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair currentPair = list.get(mid);

            if (currentPair.timestamp == timestamp) {
                return currentPair.value;
            } else if (currentPair.timestamp > timestamp) {
                right = mid - 1;
            } else if (currentPair.timestamp < timestamp) {
                left = mid + 1;
            }
        }

        if (right >= 0) {
            return list.get(right).value;
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