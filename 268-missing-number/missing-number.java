class Solution {
    public int missingNumber(int[] nums) {
        int currentIdx = 0;
        while (currentIdx < nums.length) {
            int supposeIdx = nums[currentIdx];
            if (supposeIdx < nums.length && nums[currentIdx] != nums[supposeIdx]) {
                int temp = nums[currentIdx];
                nums[currentIdx] = nums[supposeIdx];
                nums[supposeIdx] = temp;
            } else {
                currentIdx++;
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