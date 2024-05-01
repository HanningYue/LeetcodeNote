class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
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