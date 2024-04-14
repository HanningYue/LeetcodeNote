class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        
        int i = 0; 
        while (i < nums.length) {
            int supposeIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[supposeIndex]) {
                int temp = nums[supposeIndex];
                nums[supposeIndex] = nums[i];
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