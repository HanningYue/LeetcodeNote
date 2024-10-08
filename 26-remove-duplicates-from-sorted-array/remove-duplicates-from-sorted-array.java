class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) {
                continue;
            }
            slow++;
            nums[slow] = nums[fast];
        }
        return slow + 1;
    }
}