class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        Set<Integer> set = new HashSet<>();
        int slow = 0, fast = 0;
        long runningSum = 0;

        while (fast < nums.length) {
            if (set.add(nums[fast])) {
                runningSum += nums[fast];
                fast++;
            } else if (!set.add(nums[fast])){
                while (nums[slow] != nums[fast]) {
                    runningSum -= nums[slow];
                    set.remove(nums[slow]);
                    slow++;
                }
                slow++;
                fast++;
            }
            
            while (fast - slow >= k) {
                result = Math.max(result, runningSum);    
                runningSum -= nums[slow];
                set.remove(nums[slow]);
                slow++;
            }
        }
        return result;
    }
}