class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int pointer1 = 0, pointer2 = 0;
        int current = 0, last = 0;
        int totalLength = nums1.length + nums2.length;
        boolean isEven = totalLength % 2 == 0;
 
        for (int i = 0; i <= totalLength / 2; i++) {
            last = current;
            if (pointer2 >= nums2.length || (pointer1 < nums1.length && nums1[pointer1] < nums2[pointer2])) {
                current = nums1[pointer1];
                pointer1++;
            } else {
                current = nums2[pointer2];
                pointer2++;
            }
        }
        return isEven ? (last + current) / 2.0 : current;
    }
}
