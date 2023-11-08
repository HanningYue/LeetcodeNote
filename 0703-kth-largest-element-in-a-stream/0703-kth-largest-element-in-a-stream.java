/*
Want to design a algorithm where the algo return the k-th largest element in a 
    stream(constanly adding new numbers). Since we are not removing any number, 
    we can use a minHeap with size k, to track k-th largest value
1. Declear a minHeap
2. In add function, add val to minHeap, when minHeap size is greater than k, compare the val 
    with minHeap.peek()//The smallest in minHeap.
    If smaller than minHeap.peek(), poll out and offer new val
*/
class KthLargest {
    private static int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */