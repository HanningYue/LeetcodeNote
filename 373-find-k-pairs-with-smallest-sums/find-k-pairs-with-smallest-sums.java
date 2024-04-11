class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int sumA = a[0] + a[1];
                int sumB = b[0] + b[1];
                return sumA - sumB;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!heap.isEmpty() && k > 0) {
            int[] currentSmallest = heap.poll();
            int numOne = currentSmallest[0];
            int numTwo = currentSmallest[1];
            int numTwoIndex = currentSmallest[2];
            result.add(Arrays.asList(numOne, numTwo));

            if (numTwoIndex + 1 < nums2.length) {
                heap.offer(new int[]{numOne, nums2[numTwoIndex + 1], numTwoIndex + 1});
            }
            k--;
        }
        return result;
    }
}