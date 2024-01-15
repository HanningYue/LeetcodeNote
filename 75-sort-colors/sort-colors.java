class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx = 0, twoIdx = nums.length - 1;
        int i = 0;
        while (i <= twoIdx) {
            if (nums[i] == 0) {
                swap(nums, zeroIdx, i);
                zeroIdx++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, twoIdx, i);
                twoIdx--;
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}