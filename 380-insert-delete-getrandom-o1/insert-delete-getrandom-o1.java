class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int originalValue = val;
        int originalIndex = map.get(val);

        int lastIndex = list.size() - 1;
        int lastValue = list.get(list.size() - 1);

        list.set(originalIndex, lastValue);
        list.set(lastIndex, originalValue);
        list.remove(list.size() - 1);

        map.put(originalValue, lastIndex);
        map.put(lastValue, originalIndex);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(0, list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */