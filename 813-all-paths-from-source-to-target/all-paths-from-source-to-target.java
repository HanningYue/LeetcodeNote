class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, graph, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> path, int[][] graph, int vertex) {
        path.add(vertex);
        if (vertex == graph.length - 1) {
            result.add(new ArrayList<>(path));
        }
        for (int neighbor : graph[vertex]) {
            dfs(result, path, graph, neighbor);
        }
        path.remove(path.size() - 1);
    }
}