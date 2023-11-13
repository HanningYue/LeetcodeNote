/*

*/
class Solution {
    //Binary Search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = m + n;
        int half = (totalLength + 1) / 2;
        int low = 0, high = m;
        double result = 0.0;

        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = half - i;

            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (totalLength % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            }
            else if (left1 > right2) {
                high = i - 1;
            }
            else if (left2 > right1) {
                low = i + 1;
            }
        }
        return result;
    }
}