class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (map.containsKey(runningSum % k)) {
                if (i - map.get(runningSum % k) >= 2) {
                    return true;
                }
            }
            map.putIfAbsent(runningSum % k, i);
        }
        return false;
    }
}