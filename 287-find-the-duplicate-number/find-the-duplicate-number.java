class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int suppose = nums[i] - 1;
            if (nums[i] < nums.length && nums[suppose] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[suppose];
                nums[suppose] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        return nums.length;
    }
}