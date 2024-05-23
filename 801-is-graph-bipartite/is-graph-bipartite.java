class Solution {
    boolean[] visited, color;
    boolean isBipartite;
    public boolean isBipartite(int[][] graph) {
        isBipartite = true;
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        for (int i = 0; i < n; i++) {
            traverse(i, graph);
        }
        return isBipartite;
    }
    
    private void traverse(int vertex, int[][] graph) {
        if (!isBipartite) {
            return;
        }
        visited[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[vertex];
                traverse(neighbor, graph);
            } else {
                if (color[neighbor] == color[vertex]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}