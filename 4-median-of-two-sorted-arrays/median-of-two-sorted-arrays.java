class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeSortedArrays(nums1, nums2);
        return calculateMedian(mergedArray);
    }

    private int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        return merged;
    }

    private double calculateMedian(int[] nums) {
        int totalLength = nums.length;
        if (totalLength % 2 == 0) {
            return (nums[totalLength / 2 - 1] + nums[totalLength / 2]) / 2.0;
        } else {
            return nums[totalLength / 2];
        }
    }
}