class Solution {
    int[] tempArr;
    public int[] sortArray(int[] nums) {
        tempArr = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }
    private void merge(int[] nums, int left, int right, int mid) {
        int tempP = left;
        int leftP = left, rightP = mid + 1;

        while (leftP <= mid && rightP <= right) {
            if (nums[leftP] < nums[rightP]) {
                tempArr[tempP++] = nums[leftP++];
            } else {
                tempArr[tempP++] = nums[rightP++];
            }
        }
        while (leftP <= mid) {
            tempArr[tempP++] = nums[leftP++];
        }
        while (rightP <= right) {
            tempArr[tempP++] = nums[rightP++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = tempArr[i];
        }
    }
}