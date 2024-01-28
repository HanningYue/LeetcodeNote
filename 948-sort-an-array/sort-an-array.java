class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }
    private void sort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid, temp);
        sort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }
    private void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start, right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }
}