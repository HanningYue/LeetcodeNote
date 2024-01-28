class Solution {
    public int findMaximizedCapital(int number, int initial, int[] profits, int[] capital) {
        //int[] {Ascending capital, Descending profit}
        PriorityQueue<int[]> minCapital = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        for (int i = 0; i < capital.length; i++) {
            minCapital.offer(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < number; i++) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= initial) {
                maxProfit.offer(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            initial += maxProfit.poll()[1];
        }
        return initial;
    }
}