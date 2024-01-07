class Solution {
    private boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(graph, source, destination);
    }
    private boolean dfs(List<List<Integer>> graph, int vertex, int target) {
        if (vertex == target) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (dfs(graph, neighbor, target)) {
                return true;
            }
        }
        return false;
    }
}