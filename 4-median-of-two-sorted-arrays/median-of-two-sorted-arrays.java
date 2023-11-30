/*
Using (totalLength + 1) / 2 ensures that for odd lengths, the left half of the partition has one more element than the right half, which is expected in median calculation.
i -> nums1
j -> nums2 = half - i
1. If nums1 is longer than nums2, the function calls itself with the parameters reversed. This is to ensure that the binary search is performed on the shorter array.
2. The search is performed on nums1 (the shorter array).
3. i is the mid-point of the current binary search range in nums1.
ATTENTION : j is calculated to split the remaining elements from nums2.
4. If left1 is greater than right2, it means the split is too far right in nums1, so high is decreased.
5. If left2 is greater than right1, it means the split is too far left in nums1, so low is increased.
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = m + n;
        int halfLength = (totalLength + 1) / 2;
        
        int low = 0, high = m;
        while (low <= high) {
            int nums1MidIndex = low + (high - low) / 2;
            int nums2MidIndex = halfLength - nums1MidIndex;

            int nums1Left = (nums1MidIndex > 0) ? nums1[nums1MidIndex - 1] : Integer.MIN_VALUE;
            int nums1Right = (nums1MidIndex < m) ? nums1[nums1MidIndex] : Integer.MAX_VALUE;

            int nums2Left = (nums2MidIndex > 0) ? nums2[nums2MidIndex - 1] : Integer.MIN_VALUE;
            int nums2Right = (nums2MidIndex < n) ? nums2[nums2MidIndex] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums1Right >= nums2Left) {
                if (totalLength % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return (double)Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                high = nums1MidIndex - 1;
            } else {
                low = nums1MidIndex + 1;
            }
        }
        return -1;
    }
}