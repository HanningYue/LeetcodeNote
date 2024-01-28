class Solution {
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid , end);
    }
    private void merge(int[] nums, int start, int mid, int end) {
        int left = start, right = mid + 1;
        int pointer = start;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[pointer++] = nums[left++];
            } else {
                temp[pointer++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[pointer++] = nums[left++];
        }
        while (right <= end) {
            temp[pointer++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}