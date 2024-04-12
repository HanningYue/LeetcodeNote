class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> freqBucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            freqBucket.add(new ArrayList<>());
        }

        for (int num : map.keySet()) {
            int freq = map.get(num);
            freqBucket.get(freq).add(num);
        }

        int index = 0;
        for (int maxFreq = nums.length; maxFreq > 0 && index < k; maxFreq--) {
            for (int num : freqBucket.get(maxFreq)) {
                result[index] = num;
                index++;
                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}