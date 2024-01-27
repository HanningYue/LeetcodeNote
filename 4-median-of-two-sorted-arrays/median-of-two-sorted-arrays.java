class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Assume nums1 is longer than nums2
        if (nums2.length > nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int totalLength = nums1.length + nums2.length;
        int halfLength = totalLength / 2;

        int pointer1 = 0, pointer2 = 0;
        int lastElement = 0, currentElement = 0;
        boolean isEven = totalLength % 2 == 0;

        for (int i = 0; i <= halfLength; i++) {
            lastElement = currentElement;
            if (pointer1 == nums1.length) {
                currentElement = nums2[pointer2];
                pointer2++;
            } else if (pointer2 == nums2.length || nums1[pointer1] < nums2[pointer2]) {
                currentElement = nums1[pointer1];
                pointer1++;
            } else {
                currentElement = nums2[pointer2];
                pointer2++;
            }
        }
        return isEven ? (lastElement + currentElement) / 2.0 : currentElement;
    }
}