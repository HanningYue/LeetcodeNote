class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> ascendingCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> descendingProfit = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < capital.length; i++) {
            ascendingCapital.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!ascendingCapital.isEmpty() && ascendingCapital.peek()[0] <= w) {
                descendingProfit.offer(ascendingCapital.poll());
            }
            if (descendingProfit.isEmpty()) {
                return w;
            }
            w += descendingProfit.poll()[1];
        }
        return w;
    }
}