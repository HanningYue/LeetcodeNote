class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        shuffle(nums);

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotIdx = partition(nums, left, right);
            if (pivotIdx == k) {
                return nums[pivotIdx];
            } else if (pivotIdx < k) {
                left = pivotIdx + 1;
            } else if (pivotIdx > k) {
                right = pivotIdx - 1;
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
    private int partition (int[] nums, int left, int right) {
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
