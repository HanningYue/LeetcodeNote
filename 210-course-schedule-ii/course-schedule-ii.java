class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            graph.get(to).add(from);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visiting, visited, i, order)) {
                return new int[]{};
            }
        }
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visiting, boolean[] visited, int vertex, List<Integer> order) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, visiting, visited, neighbor, order)) {
                return false;
            }
        }
        order.add(vertex);
        visited[vertex] = true;
        visiting[vertex] = false;
        return true;
    }
}