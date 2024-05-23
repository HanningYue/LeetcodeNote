class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int vertexOne = edge[0], vertexTwo = edge[1];
            graph.get(vertexOne).add(vertexTwo);
            graph.get(vertexTwo).add(vertexOne);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                dfs(graph, vertex, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(Map<Integer, Set<Integer>> graph, int vertex, boolean[] visited) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}