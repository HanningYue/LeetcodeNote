class Solution {
    public int missingNumber(int[] nums) {
        int i = 0; 
        while (i < nums.length) {
            int supposeNumber = nums[i];
            if (supposeNumber < nums.length && nums[i] != nums[supposeNumber]) {
                int temp = nums[supposeNumber];
                nums[supposeNumber] = nums[i];
                nums[i] = temp;
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