class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        for (int i = 0; i < capital.length; i++) {
            minCapital.add(i);
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.offer(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w += profits[maxProfit.poll()];
        }
        return w;
    }
}