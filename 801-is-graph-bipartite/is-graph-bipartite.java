class Solution {
    private boolean bipartite = true;
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, color);
            }
        }
        return bipartite;
    }
    private void dfs(int vertex, int[][] graph, boolean[] visited, boolean[] color) {
        if (!bipartite) {
            return;
        }
        visited[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[vertex];
                dfs(neighbor, graph, visited, color);
            }
            else {
                if (color[neighbor] == color[vertex]) {
                    bipartite = false;
                    return;
                }
            }
        }
    }
}