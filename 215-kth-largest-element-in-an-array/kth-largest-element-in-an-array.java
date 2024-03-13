class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        shuffle(nums);

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == k) {
                return nums[pivot];
            }
            else if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int next = i + rand.nextInt(nums.length - i);
            swap(nums, i, next);
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leftP = left, rightP = right;
        while (leftP < rightP) {
            while (leftP < rightP && nums[rightP] >= pivot) {
                rightP--;
            }
            while (leftP < rightP && nums[leftP] <= pivot) {
                leftP++;
            }
            swap(nums, leftP, rightP);
        }
        swap(nums, left, rightP);
        return rightP;
    }
}