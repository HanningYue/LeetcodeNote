class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int supposeIndex = nums[i] - 1;
            if (nums[supposeIndex] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[supposeIndex];
                nums[supposeIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        return -1;
    }
}