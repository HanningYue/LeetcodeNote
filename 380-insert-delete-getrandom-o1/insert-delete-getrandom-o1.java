class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }   
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int originalIdx = map.get(val);
        int currentValue = list.get(list.size() - 1);
        map.put(currentValue, originalIdx);
        
        Collections.swap(list, originalIdx, list.size() - 1);
        map.remove(val);
        list.remove(list.size() - 1);
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