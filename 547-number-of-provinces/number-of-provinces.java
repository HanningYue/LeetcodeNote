class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                dfs(isConnected, vertex, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] isConnected, int vertex, boolean[] visited) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        for (int neighborCity = 0; neighborCity < isConnected.length; neighborCity++) {
            if (isConnected[vertex][neighborCity] == 1) {
                dfs(isConnected, neighborCity, visited);
            }
        }
    }
}