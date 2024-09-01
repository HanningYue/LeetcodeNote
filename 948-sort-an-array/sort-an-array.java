class Solution {
    int[] tempArray;
    public int[] sortArray(int[] nums) {
        tempArray = new int[nums.length];
        divideAndConquer(nums, 0, nums.length - 1);
        return nums;
    }
    private void divideAndConquer(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        divideAndConquer(nums, left, mid);
        divideAndConquer(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }
    private void merge(int[] nums, int left, int right, int mid) {
        int pointerOne = left, pointerTwo = mid + 1;
        int pointerThree = left;
        while (pointerOne <= mid && pointerTwo <= right) {
            if (nums[pointerOne] < nums[pointerTwo]) {
                tempArray[pointerThree++] = nums[pointerOne++];
            } else {
                tempArray[pointerThree++] = nums[pointerTwo++];
            }
        }
        while (pointerOne <= mid) {
            tempArray[pointerThree++] = nums[pointerOne++];
        }
        while (pointerTwo <= right) {
            tempArray[pointerThree++] = nums[pointerTwo++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = tempArray[i];
        }
    }
}