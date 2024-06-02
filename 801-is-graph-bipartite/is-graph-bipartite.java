class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] color = new boolean[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(i, graph, color, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int vertex, int[][] graph, boolean[] color, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[vertex];
                dfs(neighbor, graph, color, visited);
            } else {
                if (color[neighbor] == color[vertex]) {
                   return false; 
                }
            }
        }
        return true;
    }
}