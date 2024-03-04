class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = nums1.length + nums2.length;
        int halfLength = (totalLength + 1) / 2;
        boolean even = totalLength % 2 == 0;
        int left = 0, right = nums1.length;

        while (left <= right) {
            int pointer1 = left + (right - left) / 2;
            int pointer2 = halfLength - pointer1;

            int left1 = pointer1 > 0 ? nums1[pointer1 - 1] : Integer.MIN_VALUE;
            int right1 = pointer1 < nums1.length ? nums1[pointer1] : Integer.MAX_VALUE;

            int left2 = pointer2 > 0 ? nums2[pointer2 - 1] : Integer.MIN_VALUE;
            int right2 = pointer2 < nums2.length ? nums2[pointer2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (even) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } 
            else if (left1 > right2) {
                right = pointer1 - 1;
            }
            else if (left2 > right1) {
                left = pointer1 + 1;
            }
        }
        return 0.0;
    }
}