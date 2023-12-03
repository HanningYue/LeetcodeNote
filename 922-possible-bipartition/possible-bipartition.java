class Solution {
    boolean[] visited, color;
    boolean isBipartite = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            traverse(graph, i);
        }
        return isBipartite;
    }
    private void traverse(List<Integer>[] graph, int vertex) {
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
    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : dislikes) {
            int one = edge[0];
            int two = edge[1];
            graph[one].add(two);
            graph[two].add(one);
        }
        return graph;
    }
}