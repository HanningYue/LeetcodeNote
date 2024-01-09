class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        int distance = Math.abs(max - min);
        int fromLeft = Math.max(max, min) + 1;
        int fromRight = nums.length - Math.min(max, min);
        int fromBothSide = nums.length - distance + 1;
        return Math.min(fromBothSide, Math.min(fromLeft, fromRight));
    }
}