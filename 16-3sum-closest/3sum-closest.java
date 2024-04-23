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
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                    // while (i + 1 < j && nums[i + 1] == nums[i]) {
                    //     i++;
                    // }
                    // i++;
                    // while (i + 1 < j && nums[j - 1] == nums[j]) {
                    //     j--;
                    // }
                    // j--;
                } else if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else if (sum == target) {
                    return target;                   
                }
            }
        }
        return closestSum;
    }
}