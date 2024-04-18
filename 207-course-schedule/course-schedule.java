class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[] visiting = new boolean[n];
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int first = pre[1];
            int second = pre[0];
            graph.putIfAbsent(second, new HashSet<>());
            graph.get(second).add(first);
        }

        for (int vertex = 0; vertex < n; vertex++) {
            if (!dfs(vertex, graph, visiting, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int vertex, Map<Integer, Set<Integer>> graph, boolean[] visiting, boolean[] visited) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex] || !graph.containsKey(vertex)) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(neighbor, graph, visiting, visited)) {
                return false;
            }
        }
        visited[vertex] = true;
        visiting[vertex] = false;
        return true;
    }
}