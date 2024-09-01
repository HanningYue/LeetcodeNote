class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLength = nums1.length + nums2.length;
        int halfLength = (totalLength + 1) / 2;

        int left = 0, right = nums1.length;
        while (true) {
            int pointerOne = left + (right - left) / 2;
            int pointerTwo = halfLength - pointerOne;

            int leftOne = pointerOne > 0 ? nums1[pointerOne - 1] : Integer.MIN_VALUE;
            int rightOne = pointerOne < nums1.length ? nums1[pointerOne] : Integer.MAX_VALUE;
            int leftTwo = pointerTwo > 0 ? nums2[pointerTwo - 1] : Integer.MIN_VALUE;
            int rightTwo = pointerTwo < nums2.length ? nums2[pointerTwo] : Integer.MAX_VALUE;

            if (leftOne <= rightTwo && leftTwo <= rightOne) {
                if (totalLength % 2 == 0) {
                    return (double)(Math.max(leftOne, leftTwo) + Math.min(rightOne, rightTwo)) / 2.0;
                } else {
                    return Math.max(leftOne, leftTwo);
                }
            } else if (leftOne > rightTwo) {
                right = pointerOne - 1;
            } else if (leftTwo > rightOne) {
                left = pointerOne + 1;
            }
        }
    }
}