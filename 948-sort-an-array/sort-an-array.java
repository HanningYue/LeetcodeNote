class Solution {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    private void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int idx = i + rand.nextInt(nums.length - i);
            swap(nums, i, idx);
        }
    }
    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
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
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}