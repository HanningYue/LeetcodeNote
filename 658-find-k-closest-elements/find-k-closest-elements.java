class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int closeIdx = binarySearch(nums, 0, nums.length - 1, x);
        int leftBound = closeIdx - k, rightBound = closeIdx + k;

        leftBound = Math.max(0, leftBound);
        rightBound = Math.min(nums.length - 1, rightBound);

        while (rightBound - leftBound + 1 > k) {
            if (x - nums[leftBound] > nums[rightBound] - x) {
                leftBound++;
            } else {
                rightBound--;
            }
        }
        for (int i = leftBound; i <= rightBound; i++) {
            result.add(nums[i]);
        }
        return result;
    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }             
        return left;
    }
}
