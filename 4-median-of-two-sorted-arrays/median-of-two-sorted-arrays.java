class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sorted = merge(nums1, nums2);
        return findMedian(sorted);
    }
    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        
        int m = nums1.length, n = nums2.length;
        int pointerOne = 0, pointerTwo = 0, pointerThree = 0;
        
        while (pointerOne < m && pointerTwo < n) {
            if (nums1[pointerOne] < nums2[pointerTwo]) {
                result[pointerThree++] = nums1[pointerOne++];
            } else {
                result[pointerThree++] = nums2[pointerTwo++];
            }
        }
        while (pointerOne < m) {
                result[pointerThree++] = nums1[pointerOne++];
        }
        while (pointerTwo < n) {
                result[pointerThree++] = nums2[pointerTwo++];
        }

        return result;
    }
    private double findMedian(int[] nums) {
        int middleIndex = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[middleIndex - 1] + nums[middleIndex]) / 2.0;
        }
        return nums[middleIndex];
    }
}