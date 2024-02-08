class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultPointer = m + n - 1;
        int onePointer = m - 1, twoPointer = n - 1;
        while (onePointer >= 0 && twoPointer >= 0) {
            if (nums2[twoPointer] > nums1[onePointer]) {
                nums1[resultPointer] = nums2[twoPointer];
                resultPointer--;
                twoPointer--;
            } else {
                nums1[resultPointer] = nums1[onePointer];
                resultPointer--;
                onePointer--;
            }
        }
        if (onePointer >= 0) {
            return;
        } else if (twoPointer >= 0) {
            while (resultPointer >= 0 && twoPointer >= 0) {
                nums1[resultPointer] = nums2[twoPointer];
                resultPointer--;
                twoPointer--;
            }
        }
    }
}