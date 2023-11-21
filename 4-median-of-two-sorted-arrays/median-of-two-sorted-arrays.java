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
            int mid1 = low + (high - low) / 2;
            int mid2 = halfLength - mid1;

            int mid1Left = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int mid1Right = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;

            int mid2Left = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int mid2Right = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;

            if (mid1Left <= mid2Right && mid1Right >= mid2Left) {
                if (totalLength % 2 == 0) {
                    return (Math.max(mid1Left, mid2Left) + Math.min(mid1Right, mid2Right)) / 2.0;
                } else {
                    return Math.max(mid1Left, mid2Left);
                }
            } else if (mid1Left > mid2Right) {
                high = mid1 - 1;
            } else if (mid2Left > mid1Right){
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}