class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int greaterNum = -1;
            for (int j = nums2.length - 1; j >= 0 && nums2[j] != nums1[i]; j--) {
                if (nums2[j] > nums1[i]) {
                    greaterNum = nums2[j];
                }
            }
            result[i] = greaterNum;
        }
        return result;
    }
}