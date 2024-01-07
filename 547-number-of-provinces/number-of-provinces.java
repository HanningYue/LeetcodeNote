class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int currentCity = 0; currentCity < n; currentCity++) {
            if (!visited[currentCity]) {
                dfs(isConnected, visited, currentCity);
                result++;
            }
        }
        return result;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int currentCity) {
        for (int neighborCity = 0; neighborCity < isConnected[currentCity].length;
        neighborCity++) {
            if (!visited[neighborCity] && isConnected[currentCity][neighborCity] == 1) {
                visited[neighborCity] = true;
                dfs(isConnected, visited, neighborCity);
            }
        }
    }
}