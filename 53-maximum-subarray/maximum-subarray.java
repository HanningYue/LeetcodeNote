class Solution {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);        
    }
    private int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftSub = divide(nums, left, mid);
        int rightSub = divide(nums, mid + 1, right);
        int combine = conquer(nums, left, mid, right);
        
        return Math.max(combine, Math.max(leftSub, rightSub));
    }
    private int conquer(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }
        
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
}