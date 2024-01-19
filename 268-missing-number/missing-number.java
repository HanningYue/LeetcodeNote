class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int supposeIdx = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[supposeIdx]) {
                int temp = nums[i];
                nums[i] = nums[supposeIdx];
                nums[supposeIdx] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }
}