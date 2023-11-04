/**
有向有环图，想找到从一点到另一点最短cost，edge小于K
Bellman-Ford Algorithm, need a Temp Array, BFS
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0; //Initialize

        for (int i = 0; i <= k; i++) { //At MOST k stops
            int[] temp = new int[n];
            temp = Arrays.copyOf(prices, prices.length);

            for (int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int cost = flights[j][2];

                if (prices[from] == Integer.MAX_VALUE) { //If the current city is not in the trip, continue
                    continue;
                }

                //We compare prices[from] + cost < temp[to] because we want to compare all the 'cities cost'
                if (prices[from] + cost < temp[to]) { 
                    //If we find a cost smaller than previous -> Update
                    //It is like a running sum from src to the current city
                    temp[to] = prices[from] + cost;
                }
            } //End of current node cycle, reset prices（只有temp[to] 变了）
            prices = temp;
        }
        if (prices[dst] != Integer.MAX_VALUE) {
            return prices[dst];
        }
        return -1;
    }
}