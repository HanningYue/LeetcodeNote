class Solution {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    private int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftSubarray = divide(nums, left, mid);
        int rightSubarray = divide(nums, mid + 1, right);
        int combine = merge(nums, left, mid, right);

        return Math.max(combine, Math.max(leftSubarray, rightSubarray));
    }
    private int merge(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

        int sum = 0;
        for (int leftP = mid; leftP >= left; leftP--) {
            sum += nums[leftP];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for (int rightP = mid + 1; rightP <= right; rightP++) {
            sum += nums[rightP];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}