class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid + 1] < arr[mid]) {
                right = mid;
            } else if (arr[mid + 1] >= arr[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
}