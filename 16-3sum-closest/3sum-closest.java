class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int closestSum = 0;

        Arrays.sort(nums);
        for (int k = 2; k < nums.length; k++) {
            if (k + 1 < nums.length && nums[k + 1] == nums[k]) {
                continue;
            }
            int i = 0, j = k - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closest)) {
                    closest = Math.abs(sum - target);
                    closestSum = sum;
                } 
                if (sum < target) {
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}