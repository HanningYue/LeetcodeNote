class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path, result);
        return result;
    }
    private void dfs(int[][] graph, int vertex, List<Integer> path, List<List<Integer>> result) {
        path.add(vertex);
        if (vertex == graph.length - 1) {
            result.add(new ArrayList<>(path));
        }
        for (int neighbor : graph[vertex]) {
            dfs(graph, neighbor, path, result);
        }
        path.remove(path.size() - 1);
    }
}