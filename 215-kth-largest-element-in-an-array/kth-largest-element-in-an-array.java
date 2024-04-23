class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = findPivot(nums, left, right);
            if (pivot + 1 == k) {
                return nums[pivot];
            } else if (pivot + 1 > k) {
                right = pivot - 1;
            } else if (pivot + 1 < k) {
                left = pivot + 1;
            }
        }
    }
    private int findPivot(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leftP = left + 1, rightP = right;

        while (leftP <= rightP) {
            if (nums[leftP] < pivot && nums[rightP] > pivot) {
                swap(nums, leftP, rightP);
                leftP++;
                rightP--;
            }
            if (nums[leftP] >= pivot) {
                leftP++;
            }
            if (nums[rightP] <= pivot) {
                rightP--;
            }
        }
        swap(nums, left, rightP);
        return rightP;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}