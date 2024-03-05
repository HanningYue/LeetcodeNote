class Solution {
    public int findMaximizedCapital(int number, int initial, int[] profits, int[] capital) {
        //int[] arr {capital increasing, index} {profit decreasing, index}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < capital.length; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < number; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= initial) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                return initial;
            }
            initial += maxHeap.poll()[1];
        }
        return initial;
    }
}