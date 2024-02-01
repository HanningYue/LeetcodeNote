class Solution {
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
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
        int leftP = left, rightP = mid + 1;
        int arrayP = left;
        while (leftP <= mid && rightP <= right) {
            if (nums[leftP] < nums[rightP]) {
                temp[arrayP++] = nums[leftP++];
            } else {
                temp[arrayP++] = nums[rightP++];
            }
        }

        while (leftP <= mid) {
            temp[arrayP++] = nums[leftP++];
        }
        while (rightP <= right) {
            temp[arrayP++] = nums[rightP++];
        }

        for (int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }
}