class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        return dfs(graph, source, destination, visited);
    }
    private boolean dfs(List<List<Integer>> graph, int vertex, int target, 
    boolean[] visited) {
        if (vertex == target) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (dfs(graph, neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }
}