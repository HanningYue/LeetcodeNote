class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            result = Math.max(result, sum);
        }
        return result;
    }
}