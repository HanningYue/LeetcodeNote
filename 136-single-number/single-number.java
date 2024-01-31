class Solution {
    public int singleNumber(int[] nums) {
        int duplicate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            duplicate = duplicate ^ nums[i];
        }
        return duplicate;
    }
}