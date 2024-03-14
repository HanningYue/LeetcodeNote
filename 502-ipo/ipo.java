class Solution {
    public int findMaximizedCapital(int tasks, int initial, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < capital.length; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < tasks; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= initial) {
                int[] minCapital = minHeap.poll();
                maxHeap.offer(minCapital);
            }
            if (maxHeap.isEmpty()) {
                return initial;
            }
            int[] maxProfit = maxHeap.poll();
            initial += maxProfit[1];
        }
        return initial;
    }
}