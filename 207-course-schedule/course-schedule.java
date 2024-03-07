class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int currentCourse = pre[0];
            int preCourse = pre[1];
            graph.putIfAbsent(currentCourse, new HashSet<>());
            graph.get(currentCourse).add(preCourse);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited, visiting)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, int vertex, boolean[] visited, boolean[] visiting) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        if (!graph.containsKey(vertex)) {
            return true;
        }
    
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, neighbor, visited, visiting)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}