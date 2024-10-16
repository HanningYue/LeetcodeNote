class State {
    String value;
    int timestamp;
    public State(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String, List<State>> map;
    public TimeMap() {
        map = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        State state = new State(value, timestamp);
        map.get(key).add(state);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<State> list = map.get(key);
        return binarySearch(list, timestamp);
    }
    private String binarySearch(List<State> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            State state = list.get(mid);
            if (state.timestamp == timestamp) {
                return state.value;
            } else if (state.timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && right < list.size()) {
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