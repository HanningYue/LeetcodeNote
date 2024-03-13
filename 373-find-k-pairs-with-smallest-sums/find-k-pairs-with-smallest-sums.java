class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (!minHeap.isEmpty() && k > 0) {
            int[] currentSmallest = minHeap.poll();
            int numOne = currentSmallest[0];
            int numTwo = currentSmallest[1], numTwoIdx = currentSmallest[2];
            result.add(Arrays.asList(numOne, numTwo));

            if (numTwoIdx + 1 < nums2.length) {
                minHeap.offer(new int[]{numOne, nums2[numTwoIdx + 1], numTwoIdx + 1});
            }
            k--;
        }
        return result;
    }
}