class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int slow = 0, fast = 0;
        long maxSum = 0, runningSum = 0;
        Set<Integer> set = new HashSet<>();

        while (fast < nums.length) {
            runningSum += nums[fast];
            while (set.contains(nums[fast]) || (fast - slow + 1 > k)) {
                runningSum -= nums[slow];
                set.remove(nums[slow]);
                slow++;
            }
            set.add(nums[fast]);
            if (fast - slow + 1 == k) {
                maxSum = Math.max(maxSum, runningSum);
            }
            fast++;            
        }
        return maxSum;
    }
}