class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndexOfOne = m - 1;
        int lastIndexOfTwo = n - 1;
        int totalLength = m + n - 1;

        while (lastIndexOfOne >= 0 && lastIndexOfTwo >= 0) {
            if (nums1[lastIndexOfOne] < nums2[lastIndexOfTwo]) {
                nums1[totalLength--] = nums2[lastIndexOfTwo--];
            } else {
                nums1[totalLength--] = nums1[lastIndexOfOne--];
            }
        }
        while (lastIndexOfTwo >= 0) {
            nums1[totalLength--] = nums2[lastIndexOfTwo--];
        }
    }
}