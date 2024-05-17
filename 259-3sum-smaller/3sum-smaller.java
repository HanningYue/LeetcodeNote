class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    result += (j - i);
                    i++;
                } else if (sum >= target) {
                    j--;
                }
            }
        }
        return result;
    }
}