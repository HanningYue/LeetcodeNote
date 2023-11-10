/**
有向有环图，想找到从一点到另一点最短cost，edge小于K, 
Bellman-Ford Algorithm, need a Temp Array, BFS in a 2-D Array
1. For loop 1, 小于K
2. For loop 2, 穷举flights array
    如果start城市不是src 跳过，== Integer.MAX_VALUE
    更新邻居城市的cost
3. Reset prices array = temp array 这时的prices array已经把所有的邻居城市cost都更新了
4. 如果dst不是 最大值，返还 minimum 不然返还-1
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            temp = Arrays.copyOf(prices, prices.length);
            
            for (int j = 0; j < flights.length; j++) {
                int departCity = flights[j][0];
                int arriveCity = flights[j][1];
                int cost = flights[j][2];
                
                if (prices[departCity] == Integer.MAX_VALUE) continue;
                
                if (prices[departCity] + cost < temp[arriveCity]) {
                    temp[arriveCity] = prices[departCity] + cost;
                }
            }
            prices = temp;
        }
        if (prices[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return prices[dst];
    }
}