class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastP = m + n - 1;
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        while (pointer2 >= 0 && pointer1 >= 0) {
            if (nums2[pointer2] >= nums1[pointer1]) {
                nums1[lastP--] = nums2[pointer2--];
            }
            else if (nums1[pointer1] > nums2[pointer2]){
                nums1[lastP--] = nums1[pointer1--];                
            }
        }

        while (pointer2 >= 0) {
            nums1[lastP--] = nums2[pointer2--];
        }
        while (pointer1 >= 0) {
            nums1[lastP--] = nums1[pointer1--];
        }
    }
}