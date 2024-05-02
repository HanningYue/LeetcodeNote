class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int slow = 0;
        long maxSum = 0, runningSum = 0;
        Set<Integer> set = new HashSet<>();

        for (int fast = 0; fast < nums.length; fast++) {
            // Remove elements until there are no duplicates and window size is within k
            while (set.contains(nums[fast]) || fast - slow >= k) {
                runningSum -= nums[slow];
                set.remove(nums[slow++]);
            }
            
            // Add current element to the running sum and set
            runningSum += nums[fast];
            set.add(nums[fast]);

            // Check for maximum sum when the window size is exactly k
            if (fast - slow + 1 == k) {
                maxSum = Math.max(maxSum, runningSum);
            }
        }
        return maxSum;
    }
}
