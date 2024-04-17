class Solution {
    Map<Integer, List<int[]>> map;
    Integer[][] dpTable;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        map = new HashMap<>();
        dpTable = new Integer[n][k + 1];
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            map.putIfAbsent(to, new LinkedList<>());
            map.get(to).add(new int[]{from, price});
        }
        return dp(dst, k, src, dst);
    }
    private int dp(int sourceCity, int k, int src, int dst) {
        if (src == sourceCity) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (dpTable[sourceCity][k] != null) {
            return dpTable[sourceCity][k];
        }

        int result = Integer.MAX_VALUE;
        if (map.containsKey(sourceCity)) {
            for (int[] path : map.get(sourceCity)) {
                int from = path[0];
                int price = path[1];
                int subProblem = dp(from, k - 1, src, dst);
                if (subProblem != -1) {
                    result = Math.min(result, subProblem + price);
                }
            }
        }
        dpTable[sourceCity][k] = result == Integer.MAX_VALUE ? -1 : result;
        return dpTable[sourceCity][k];
    }
}