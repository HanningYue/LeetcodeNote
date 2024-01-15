class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int slow = 0;
        int result = 0;
        int runningSum = 1;
        for (int fast = 0; fast < nums.length; fast++) {
            runningSum *= nums[fast];
            while (runningSum >= k && slow <= fast) {
                runningSum /= nums[slow];
                slow++;
            }
            result += fast - slow + 1;
        }
        return result;
    }
}