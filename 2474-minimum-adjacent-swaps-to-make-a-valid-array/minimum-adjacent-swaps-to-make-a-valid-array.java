class Solution {
    public int minimumSwaps(int[] nums) {
        int left = 0, right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[right] < nums[nums.length - 1 - i]) {
                right = nums.length - 1 - i;
            }

            if (nums[left] > nums[i]) {
                left = i;
            }
        }
        return (nums.length - 1 - right) + left - (left > right ? 1 : 0);
    }
}