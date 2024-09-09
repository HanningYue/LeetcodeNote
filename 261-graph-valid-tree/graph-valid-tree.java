class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(0, visited, graph);
        return visited.size() == n;
    }
    private void dfs(int vertex, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            dfs(neighbor, visited, graph);
        }
    }
}
