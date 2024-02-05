class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(graph, new ArrayList<>(), 0, result);
        return result;
    }
    private void backTrack(int[][] graph, List<Integer> list, int vertex, List<List<Integer>> result) {
        list.add(vertex);
        if (vertex == graph.length - 1) {
            result.add(new ArrayList<>(list));
        }

        for (int neighbor : graph[vertex]) {
            backTrack(graph, list, neighbor, result);
        }
        
        list.remove(list.size() - 1);
    }
}