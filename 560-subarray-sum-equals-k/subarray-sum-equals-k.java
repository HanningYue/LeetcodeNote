class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int runningSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (map.containsKey(runningSum - k)) {
                count += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}