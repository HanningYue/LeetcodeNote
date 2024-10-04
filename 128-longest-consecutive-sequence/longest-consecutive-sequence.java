class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int localLength = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                if (nums[i] == nums[i - 1] + 1) {
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