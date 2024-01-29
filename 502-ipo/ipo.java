class Solution {
    public int findMaximizedCapital(int number, int initial, int[] profits, int[] capital) {
        //{cap, profit}
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < capital.length; i++)  {
            minCap.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < number; i++) {
            while (!minCap.isEmpty() && minCap.peek()[0] <= initial) {
                maxPro.offer(minCap.poll());
            }
            if (maxPro.isEmpty()) {
                return initial;
            }
            initial += maxPro.poll()[1];
        }
        return initial;
    }
}