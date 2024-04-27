class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, graph, visiting, visited, -1)) {
            return false;
        }
        return visited.size() == n;
    }
    private boolean dfs(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visiting, 
    Set<Integer> visited, int parent) {
        if (visiting.contains(vertex)) {
            return false;
        }
        if (visited.contains(vertex)) {
            return true;
        }
        visiting.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            if (neighbor != parent && !dfs(neighbor, graph, visiting, visited, vertex)) {
                return false;
            }
        }
        visiting.remove(vertex);
        visited.add(vertex);
        return true;
    }
}