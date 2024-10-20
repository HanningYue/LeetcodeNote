class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexOne = m - 1, indexTwo = n - 1;
        int indexThree = m + n - 1;
        
        while (indexOne >= 0 && indexTwo >= 0) {
            if (nums2[indexTwo] >= nums1[indexOne]) {
                nums1[indexThree] = nums2[indexTwo];
                indexTwo--;
            } else {
                nums1[indexThree] = nums1[indexOne];
                indexOne--;
            }
            indexThree--;
        }

        while (indexTwo >= 0) {
            nums1[indexThree] = nums2[indexTwo];
            indexTwo--;
            indexThree--;
        }
    }
}