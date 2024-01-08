class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        int distance = Math.abs(maxIndex - minIndex);
        int fromLeft = Math.max(maxIndex, minIndex) + 1;
        int fromRight = n - Math.min(maxIndex, minIndex);
        int fromBothSide = n - distance + 1;
        return Math.min(fromBothSide, Math.min(fromLeft, fromRight));
    }
}