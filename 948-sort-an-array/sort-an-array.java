class Solution {
    private int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        divide(nums, 0, nums.length - 1);
        return nums;
    }
    private void divide(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        divide(nums, left, mid);
        divide(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }
    private void merge(int[] nums, int left, int right, int mid) {
        int leftP = left, rightP = mid + 1, tempP = left;
        while (leftP <= mid && rightP <= right) {
            if (nums[leftP] < nums[rightP]) {
                temp[tempP++] = nums[leftP++];
            } else {
                temp[tempP++] = nums[rightP++];
            }
        }
        while (leftP <= mid) {
            temp[tempP++] = nums[leftP++];
        }
        while (rightP <= right) {
            temp[tempP++] = nums[rightP++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }
}