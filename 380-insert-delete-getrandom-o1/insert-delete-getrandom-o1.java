//When deleting, make sure the element is at the end of array, swap with current end
class RandomizedSet {
    Map<Integer, Integer> map; //{value, index in list}
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
        int indexInList = map.get(val);
        int currentEnd = list.size() - 1;
        int currentEndElement = list.get(list.size() - 1);

        map.put(currentEndElement, indexInList);
        map.remove(val);
        Collections.swap(list, indexInList, currentEnd);
        list.remove(list.size() - 1);

        return true;
    }
    
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */