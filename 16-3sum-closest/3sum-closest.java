class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                }
            }
        }
        return closestSum;
    }
}