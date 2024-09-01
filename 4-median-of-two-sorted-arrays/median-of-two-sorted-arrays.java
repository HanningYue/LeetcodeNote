class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = merge(nums1, nums2);
        return findMedian(mergedArray);
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] result = new int[n + m];

        int pointerOne = 0, pointerTwo = 0, pointerThree = 0;
        while (pointerOne < n && pointerTwo < m) {
            if (nums1[pointerOne] < nums2[pointerTwo]) {
                result[pointerThree++] = nums1[pointerOne++];
            } else {
                result[pointerThree++] = nums2[pointerTwo++];
            }
        }
        while (pointerOne < n) {
            result[pointerThree++] = nums1[pointerOne++];
        }
        while (pointerTwo < m) {
            result[pointerThree++] = nums2[pointerTwo++];
        }

        return result;
    }

    private double findMedian(int[] arr) {
        int middleIndex = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (arr[middleIndex - 1] + arr[middleIndex]) / 2.0;
        } else {
            return arr[middleIndex];
        }
    }
}