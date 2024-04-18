class Solution {
    public int maxProduct(int[] nums) {
        int left = 1, right = 1;
        int n = nums.length;
        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;
            left = left * nums[i];
            right = right * nums[n - 1 - i];
            result = Math.max(result, Math.max(left, right));
        }
        return result;
    }
}