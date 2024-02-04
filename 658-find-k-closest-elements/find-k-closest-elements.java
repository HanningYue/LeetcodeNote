class Solution {
    public List<Integer> findClosestElements(int[] nums, int distance, int target) {
        List<Integer> result = new ArrayList<>();
        int targetIdx = binarySearch(nums, 0, nums.length - 1, target);
        
        int left = targetIdx - distance;
        int right = targetIdx + distance;
        left = Math.max(0, left);
        right = Math.min(nums.length - 1, right);

        while (right - left + 1 > distance) {
            if (nums[right] - target >= target - nums[left]) {
                right--;
            } else if (nums[right] - target < target - nums[left]) {
                left++;
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(nums[i]);
        }
        return result;
    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}