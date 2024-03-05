class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });        

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!minHeap.isEmpty() && k > 0) {
            int[] current = minHeap.poll();
            int num1 = current[0], num2 = current[1];
            int nums2Idx = current[2];

            result.add(Arrays.asList(num1, num2));

            if (nums2Idx < nums2.length - 1) {
                minHeap.offer(new int[]{num1, nums2[nums2Idx + 1], nums2Idx + 1});
            }
            k--;
        }
        return result;
    }
}