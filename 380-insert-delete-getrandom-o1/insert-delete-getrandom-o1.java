class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int originalIndex = map.get(val);
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);
        
        map.put(lastValue, originalIndex);
        map.put(val, lastIndex);
        map.remove(val);
        
        swap(list, originalIndex, lastIndex);
        list.remove(list.size() - 1);
        return true;
    }
    private void swap(List<Integer> list, int left, int right) {
        int leftValue = list.get(left);
        int rightValue = list.get(right);
        list.set(right, leftValue);
        list.set(left, rightValue);
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