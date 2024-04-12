class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> freqBucket = new ArrayList<>();
        for (int freq = 0; freq <= nums.length; freq++) {
            freqBucket.add(new ArrayList<>());
        }

        for (int num : map.keySet()) {
            int numFreq = map.get(num);
            freqBucket.get(numFreq).add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for (int maxFreq = nums.length; maxFreq > 0 && index < k; maxFreq--) {
            for (int num : freqBucket.get(maxFreq)) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}