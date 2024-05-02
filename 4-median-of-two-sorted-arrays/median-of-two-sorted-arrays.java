class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeSort(nums1, nums2);
        return median(array);
    }
    private int[] mergeSort(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while (j < n) {
            result[k++] = nums2[j++];
        }
        return result;
    }
    private double median(int[] nums) {
        int middleIndex = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[middleIndex - 1] + nums[middleIndex]) / 2.0;
        } else {
            return nums[middleIndex];
        }
    }
}