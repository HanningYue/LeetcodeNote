class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                result++;
                dfs(isConnected, visited, i);
            }
        }
        return result;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int neighbor = 0; neighbor < isConnected[vertex].length; neighbor++) {
            if (isConnected[vertex][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}