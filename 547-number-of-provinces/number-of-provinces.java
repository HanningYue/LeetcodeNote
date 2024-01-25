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
    private void dfs(int[][] graph, int vertex, boolean[] visited) {
        for (int i = 0; i < graph[vertex].length; i++) {
            if (!visited[i] && graph[vertex][i] == 1) {
                visited[i] = true;
                dfs(graph, i, visited);
            }
        }
    }
}