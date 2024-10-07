class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    closestSum = sum;
                }
                if (sum < target) {
                    while (i + 1 < j && nums[i + 1] == nums[i]) {
                        i++;
                    }
                    i++;
                } else if (sum > target) {
                    while (i + 1 < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    j--;
                }
            }
        }
        return closestSum;
    }
}