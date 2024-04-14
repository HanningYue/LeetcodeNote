class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int supposeIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length
            && nums[supposeIndex] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[supposeIndex];
                nums[supposeIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}