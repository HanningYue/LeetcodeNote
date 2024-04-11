class Pair {
    int nums1, nums2, nums2Idx;
    public Pair(int nums1, int nums2, int nums2Idx) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.nums2Idx = nums2Idx;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                int sumA = a.nums1 + a.nums2;
                int sumB = b.nums1 + b.nums2;
                return sumA - sumB;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new Pair(nums1[i], nums2[0], 0));
        }
        
        int count = 0;
        while (!heap.isEmpty() && count < k) {
            Pair currentSmallest = heap.poll();
            int numOne = currentSmallest.nums1;
            int numTwo = currentSmallest.nums2;
            int numTwoIndex = currentSmallest.nums2Idx;
            result.add(Arrays.asList(numOne, numTwo));

            if (numTwoIndex + 1 < nums2.length) {
                heap.offer(new Pair(numOne, nums2[numTwoIndex + 1], numTwoIndex + 1));
            }
            count++;
        }
        return result;
    }
}