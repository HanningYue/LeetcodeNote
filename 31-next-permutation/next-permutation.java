class Solution {
    public void nextPermutation(int[] nums) {
        int firstDecrease = nums.length - 2;
        while (firstDecrease >= 0 && nums[firstDecrease + 1] <= nums[firstDecrease]) {
            firstDecrease--;
        }
        if (firstDecrease == -1) {
            reverse(nums, 0);
            return;
        }

        if (firstDecrease >= 0) {
            int firstGreater = nums.length - 1;
            while (firstGreater > 0 && nums[firstGreater] <= nums[firstDecrease]) {
                firstGreater--;
            }
            swap(nums, firstDecrease, firstGreater);
        }

        reverse(nums, firstDecrease + 1);
    }
    private void reverse(int[] nums, int index) {
        int left = index, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}