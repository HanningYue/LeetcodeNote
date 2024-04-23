class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;

        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    count += j - i;
                    i++;
                } else if (sum > target) {
                    j--;
                } else if (sum == target) {
                    j--;
                }
            }
        }
        return count;
    }
}