/* 用一个minHeap和一个maxHeap 两边互相加减来保持sorted属性和size相同属性
1. In addNumber function, we ALWAYS MAINTAIN a balance between the size of minHeap and maxHeap as possible.
    Add to maxHeap, /if maxHeap is one element greater than minHeap /or the just added number is greater than 
    the smallest in minHeap, pop the number from maxHeap and add it to minHeap
    /Otherwise, when minHeap is greater than maxHeap by one, pop back to maxHeap
2. findMedian
        maxHeap     minHeap
        Leftheap, Rightheap
Scenario one: even total number, combine maxHeap max with minHeap min / 2
Scenario two: odd total number, one heap is bigger than the other
    if maxHeap is bigger, return the maxHeap.peek()
    if minHeap is bigger, return the minHeap.peek();
When implementing findMedian, always use peek(), because the nature of stream, we need to keep element complete
*/
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if (maxHeap.size() > minHeap.size() + 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size % 2 == 0) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return (double)minHeap.peek();
        } else {
            return (double)maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */