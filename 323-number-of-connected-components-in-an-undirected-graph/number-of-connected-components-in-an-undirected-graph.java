class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            graph.putIfAbsent(vertexOne, new HashSet<>());
            graph.putIfAbsent(vertexTwo, new HashSet<>());
            graph.get(vertexTwo).add(vertexOne);
            graph.get(vertexOne).add(vertexTwo);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                count++;
                dfs(graph, visited, vertex);
            }
        }
        return count;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int vertex) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        if (!graph.containsKey(vertex)) {
            return;
        }
        
        for (int neighbor : graph.get(vertex)) {
            dfs(graph, visited, neighbor);
        }
    }
}