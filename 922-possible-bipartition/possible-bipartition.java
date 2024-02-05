class Solution {
    private boolean bipartite = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] person : dislikes) {
            int personA = person[0] - 1;
            int personB = person[1] - 1;
            graph.get(personA).add(personB);
            graph.get(personB).add(personA);
        }

        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, color);
            }
        }
        return bipartite;
    }
    private void dfs(int vertex, List<List<Integer>> graph, boolean[] visited, boolean[] color) {
        if (!bipartite) {
            return;
        }
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
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