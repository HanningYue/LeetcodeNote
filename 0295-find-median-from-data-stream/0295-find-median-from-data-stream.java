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
*/
class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> (a - b));
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() > minHeap.size() + 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (maxHeap.size() < minHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */