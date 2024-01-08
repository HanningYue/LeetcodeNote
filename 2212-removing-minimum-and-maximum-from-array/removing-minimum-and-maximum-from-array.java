class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }        

        int distance = Math.abs(minIndex - maxIndex);
        int fromLeft = Math.max(minIndex, maxIndex) + 1;
        int fromRight = n - Math.min(minIndex, maxIndex);
        int fromBothSide = n - Math.max(minIndex, maxIndex) + Math.min(minIndex, maxIndex) + 1;
        return Math.min(fromBothSide, Math.min(fromLeft, fromRight));
    }
}