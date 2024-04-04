class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int num : map.keySet()) {
            int freq = map.get(num);
            bucket.get(freq).add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for (int currentFreq = nums.length; currentFreq > 0 && index < k; currentFreq--) {
            for (int num : bucket.get(currentFreq)) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}