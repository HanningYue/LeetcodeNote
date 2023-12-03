class Solution {
    boolean[] visited, color;
    boolean isBipartite = true;

    public boolean isBipartite(int[][] graph) {
        visited = new boolean[graph.length];
        color = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            traverse(graph, i);
        }
        return isBipartite;
    }
    private void traverse(int[][] graph, int vertex) {
        if (!isBipartite) {
            return;
        }
        
        visited[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[vertex];
                traverse(graph, neighbor);
            } else {
                if (color[neighbor] == color[vertex]) {
                    isBipartite = false;
                }
            }
        }
    }
}