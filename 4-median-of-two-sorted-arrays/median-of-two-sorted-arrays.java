class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tempArr = mergeSort(nums1, nums2);
        return findMedian(tempArr);
    }
    
    private int[] mergeSort(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] tempArr = new int[m + n];

        int pointerOne = 0, pointerTwo = 0, tempPointer = 0;
        while (pointerOne < m && pointerTwo < n) {
            if (nums1[pointerOne] < nums2[pointerTwo]) {
                tempArr[tempPointer++] = nums1[pointerOne++];
            } else {
                tempArr[tempPointer++] = nums2[pointerTwo++];
            }
        }
        while (pointerOne < m) {
            tempArr[tempPointer++] = nums1[pointerOne++];
        }
        while (pointerTwo < n) {
            tempArr[tempPointer++] = nums2[pointerTwo++];
        }
        return tempArr;
    }

    private double findMedian(int[] tempArr) {
        boolean even = tempArr.length % 2 == 0;
        int middleIndex = tempArr.length / 2;
        
        if (even) {
            return (tempArr[middleIndex - 1] + tempArr[middleIndex]) / 2.0;
        } else {
            return tempArr[middleIndex];
        }
    }
}