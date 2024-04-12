class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> freq = new ArrayList<>(map.keySet());
        Collections.sort(freq, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(b).compareTo(map.get(a));
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freq.get(i);
        }
        return result;
    }
}