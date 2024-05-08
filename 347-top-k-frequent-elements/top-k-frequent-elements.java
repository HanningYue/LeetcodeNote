class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int number : map.keySet()) {
            int frequency = map.get(number);
            bucket.get(frequency).add(number);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0; i--) {
            for (int number : bucket.get(i)) {
                result[index++] = number;
                if (index == k) {
                    return result;
                }
            }
        }
        return new int[]{};
    }
}