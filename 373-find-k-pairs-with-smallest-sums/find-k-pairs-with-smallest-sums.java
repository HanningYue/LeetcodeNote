class Pair {
    int num1;
    int num2;
    int num2Index;
    public Pair(int num1, int num2, int num2Index) {
        this.num1 = num1;
        this.num2 = num2;
        this.num2Index = num2Index;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> (a.num1 + a.num2) - (b.num1 + b.num2));
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new Pair(nums1[i], nums2[0], 0));
        }

        while (!minHeap.isEmpty() && k > 0) {
            Pair current = minHeap.poll();
            int num1 = current.num1, num2 = current.num2, num2Index = current.num2Index;

            result.add(Arrays.asList(num1, num2));

            if (num2Index + 1 < nums2.length) {
                minHeap.offer(new Pair(num1, nums2[num2Index + 1], num2Index + 1));
            }
            k--;
        }
        return result;
    }
}