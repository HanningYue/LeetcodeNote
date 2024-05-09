class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int runningSum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (map.containsKey(runningSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(runningSum - k));
            }
            map.putIfAbsent(runningSum, i);
        }
        return maxLength;
    }
}