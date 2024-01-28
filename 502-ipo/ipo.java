class Solution {
    public int findMaximizedCapital(int number, int initialCap, int[] profits, int[] capital) {
        //{capital, profit}
        PriorityQueue<int[]> minCap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> maxPro = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            } 
        });

        for (int i = 0; i < capital.length; i++) {
            minCap.offer(new int[]{capital[i], profits[i]});
        }    
        for (int i = 0; i < number; i++) {
            while (!minCap.isEmpty() && minCap.peek()[0] <= initialCap) {
                maxPro.offer(minCap.poll());
            }
            if (maxPro.isEmpty()) {
                break;
            }
            initialCap += maxPro.poll()[1];
        }
        return initialCap;
    }
}