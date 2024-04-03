class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //{num, frequency}
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : map.keySet()) {
            int frequency = map.get(num);
            buckets.get(frequency).add(num);
        }
        
        int[] result = new int[k];
        int position = 0;
        for (int i = nums.length; i > 0 && position < k; i--) {
            for (int num : buckets.get(i)) {
                result[position++] = num;
                if (position == k) break;
            }
        }
        
        return result;
    }
}