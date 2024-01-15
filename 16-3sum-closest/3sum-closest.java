class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
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
        return closest;
    }
}