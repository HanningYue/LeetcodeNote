class Pair {
    int sum;
    int num1;
    int num2;
    public Pair(int num1, int num2) {
        this.sum = num1 + num2;
        this.num1 = num1;
        this.num2 = num2;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((a, b) -> b.sum - a.sum);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new Pair(nums1[i], nums2[j]));
                } 
                else if (maxHeap.size() >= k){
                    if (nums1[i] + nums2[j] >= maxHeap.peek().sum) {
                        break;
                    } 
                    else if (nums1[i] + nums2[j] < maxHeap.peek().sum){
                        maxHeap.poll();
                        maxHeap.offer(new Pair(nums1[i], nums2[j]));
                    }
                }
            }
        }

        while (!maxHeap.isEmpty() && k > 0) {
            Pair pair = maxHeap.poll();
            result.add(Arrays.asList(pair.num1, pair.num2));
            k--;
        }
        return result;
    }
}