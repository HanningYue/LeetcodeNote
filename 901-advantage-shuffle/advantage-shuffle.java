class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        //pq save int[] {value, index}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });

        for (int i = 0; i < nums2.length; i++) {
            maxHeap.offer(new int[]{nums2[i], i});
        }
        
        Arrays.sort(nums1);
        int left = 0, right = nums1.length - 1;
        while (!maxHeap.isEmpty()) {
            int[] nums2Max = maxHeap.poll();
            int value = nums2Max[0], index = nums2Max[1];
            if (nums1[right] > value) {
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