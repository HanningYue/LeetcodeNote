class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int k = 2; k < nums.length; k++) {
            if (k + 1 < nums.length && nums[k + 1] == nums[k]) {
                continue;
            }
            int i = 0, j = k - 1;
            while (i < j) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}