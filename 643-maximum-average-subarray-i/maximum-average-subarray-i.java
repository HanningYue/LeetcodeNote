class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        // Compute prefix sums up to index n
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        
        double result = Double.NEGATIVE_INFINITY;
        for (int slow = 0, fast = k - 1; fast < nums.length; slow++, fast++) {
            double localResult = (double)(prefix[fast + 1] - prefix[slow]) / k;
            result = Math.max(result, localResult);
        }
        return result;
    }
}
