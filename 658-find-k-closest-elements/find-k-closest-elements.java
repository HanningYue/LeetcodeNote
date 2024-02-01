class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int xIdx = binarySearch(arr, 0, arr.length - 1, x);

        int leftBound = xIdx - k, rightBound = xIdx + k;
        leftBound = Math.max(leftBound, 0);
        rightBound = Math.min(arr.length - 1, rightBound);

        while (rightBound - leftBound + 1 > k) {
            if (x - arr[leftBound] > arr[rightBound] - x) {
                leftBound++;
            } else if (x - arr[leftBound] <= arr[rightBound] - x) {
                rightBound--;
            }
        }
        for (int i = leftBound; i <= rightBound; i++) {
            result.add(arr[i]);
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
        return left; //Maintain insertion order
    }
}