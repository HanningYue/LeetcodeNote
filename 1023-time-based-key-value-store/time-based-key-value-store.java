/*
We need to use a map for relation of key and timestamp 
    and a Pair for value of timestamp and timestamp
Map<String, List<Pair<String, Integer>>>...     For each key, there might be ArrayList<Pair<String, Integer>>
    key                value  timestamp
When Binary search, 求target timestamp value, 正常+1 和 —1. 
    high is the index of last Pair value in list
但是在末尾加入检查条件，如果没有找到equal或者有好几个
    如果high >= 0并且 getvalue <= timestamp，return 最大(右边界)的value
*/
class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<Pair<String, Integer>>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<String, Integer>> list = map.get(key);
        return helper(list, timestamp);
    }
    private String helper(List<Pair<String, Integer>> list, int timestamp) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).getValue() < timestamp) {
                low = mid + 1;
            } else if (list.get(mid).getValue() > timestamp){
                high = mid - 1;
            } else {
                return list.get(mid).getKey();
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