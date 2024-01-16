class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        Set<Integer> set = new HashSet<>();
        int slow = 0, fast = 0;
        long runningSum = 0;
        while (fast < nums.length) {
            runningSum += nums[fast];
            while (set.contains(nums[fast]) || (fast - slow + 1 > k)) {
                runningSum -= nums[slow];
                set.remove(nums[slow]);
                slow++;
            }
            set.add(nums[fast]);
            if (fast - slow + 1 == k) {
                result = Math.max(result, runningSum);
            }
            fast++;
        }
        return result;
    }
}