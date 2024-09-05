class Pair {
    int cap;
    int profit;
    public Pair (int cap, int profit) {
        this.cap = cap;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> descendingProfit = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        PriorityQueue<Pair> aescendingCapital = new PriorityQueue<>((a, b) -> a.cap - b.cap);
        
        for (int i = 0; i < capital.length; i++) {
            aescendingCapital.offer(new Pair(capital[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!aescendingCapital.isEmpty() && aescendingCapital.peek().cap <= w) {
                descendingProfit.offer(aescendingCapital.poll());
            }
            if (descendingProfit.isEmpty()) {
                return w;
            }
            Pair currentMaxProfit = descendingProfit.poll();
            w += currentMaxProfit.profit;
        }
        return w;
    }
}