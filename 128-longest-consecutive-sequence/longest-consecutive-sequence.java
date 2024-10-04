class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLength = 0, localLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                if (nums[i - 1] + 1 == nums[i]) {
                    localLength++;
                } else {
                    maxLength = Math.max(maxLength, localLength);
                    localLength = 1;
                }
            }
        }
        return Math.max(maxLength, localLength);
    }
}