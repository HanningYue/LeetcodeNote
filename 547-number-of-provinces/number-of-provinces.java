class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                result++;
            }
        }
        return result;
    }
    private void dfs(int[][] isConnected, int vertex, boolean[] visited) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        for (int i = 0; i < isConnected[vertex].length; i++) {
            if (isConnected[vertex][i] != 1) {
                continue;
            }
            dfs(isConnected, i, visited);
        }
    }
}