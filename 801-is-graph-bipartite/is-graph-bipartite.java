class Solution {
    boolean isBipartite = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];        
        for (int currentVertex = 0; currentVertex < graph.length; currentVertex++) {    
            dfs(graph, visited, currentVertex, color);
        }
        return isBipartite;
    }
    private void dfs(int[][] graph, boolean[] visited, int vertex, boolean[] color) {
        visited[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[vertex];
                dfs(graph, visited, neighbor, color);
            } else {
                if (color[neighbor] == color[vertex]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}