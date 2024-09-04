class Pair {
    int indexOne, indexTwo, sum;
    public Pair(int indexOne, int indexTwo, int sum) {
        this.indexOne = indexOne;
        this.indexTwo = indexTwo;
        this.sum = sum;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }
        while (!heap.isEmpty() && k > 0) {
            List<Integer> temp = new ArrayList<>();
            Pair currentPair = heap.poll();
            int currentIndexOne = currentPair.indexOne;
            int currentIndexTwo = currentPair.indexTwo;

            if (currentIndexTwo + 1 < nums2.length) {
                heap.offer(new Pair(currentIndexOne, currentIndexTwo + 1, 
                nums1[currentIndexOne] + nums2[currentIndexTwo + 1]));
            }

            temp.add(nums1[currentIndexOne]);
            temp.add(nums2[currentIndexTwo]);
            result.add(temp);
            k--;
        }
        return result;
    }
}