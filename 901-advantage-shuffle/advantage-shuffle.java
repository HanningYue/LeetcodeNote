class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        //maxHeap to save int[], int[0] = index, int[1] = value
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < nums2.length; i++) {
            maxHeap.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int left = 0, right = nums1.length - 1;
        while (!maxHeap.isEmpty()) {
            int[] maxOfTwo = maxHeap.poll();
            int index = maxOfTwo[0], maxVal = maxOfTwo[1];

            if (nums1[right] > maxVal) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }
        }
        return result;
    }
}