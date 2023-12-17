/**
Directional Graph, build graph first, then check for cycle, if no cycle, return true. Otherwise, false
Since directional, build single directional graph
无向图可以当作双向图来build
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[0], new HashSet<>());
            graph.get(pre[0]).add(pre[1]);
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visiting, visited, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visiting, 
    boolean[] visited, int vertex) {
        if (!graph.containsKey(vertex) || visited[vertex]) {
            return true;
        }
        if (visiting[vertex]) {
            return false;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, visiting, visited, neighbor)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}