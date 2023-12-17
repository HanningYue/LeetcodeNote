class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                result++;
                dfs(visited, i, isConnected);
            }
        }
        return result;
    }
    private void dfs(boolean[] visited, int vertex, int[][] isConnected) {
        visited[vertex] = true;
        for (int neighbor = 0; neighbor < isConnected[vertex].length; neighbor++) {
            if (isConnected[vertex][neighbor] == 1 && !visited[neighbor]) {
                dfs(visited, neighbor, isConnected);
            }
        }
    }

}