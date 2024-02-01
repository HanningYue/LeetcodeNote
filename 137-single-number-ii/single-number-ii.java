class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
                sum %= 3;
            }
            result = result | (sum << i);
        }
        return result;
    }
}