class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int lastIdx = result.length - 1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[lastIdx] = leftSquare;
                lastIdx--;
                left++;
            } else if (rightSquare >= leftSquare) {
                result[lastIdx] = rightSquare;
                lastIdx--;
                right--;
            }
        }
        return result;
    }
}