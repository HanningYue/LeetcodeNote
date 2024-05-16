class Solution {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k_smallest) {
        if (left == right) return nums[left];

        // Randomly choose pivot. This is crucial for performance improvement.
        int pivotIndex = left + rand.nextInt(right - left);

        pivotIndex = partition(nums, left, right, pivotIndex);

        // The pivot is in its final sorted position
        if (k_smallest == pivotIndex) {
            return nums[k_smallest];
        } else if (k_smallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k_smallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k_smallest);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // move pivot to end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // Move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(nums, storeIndex, right);

        return storeIndex;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
