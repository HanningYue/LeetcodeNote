class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] pre : prerequisites) {
            int currentCourse = pre[0];
            int preCourse = pre[1];
            graph.putIfAbsent(currentCourse, new HashSet<>());
            graph.get(currentCourse).add(preCourse);
        }

        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visiting, visited, i, list)) {
                return new int[]{};
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visiting, 
    boolean[] visited, int vertex, List<Integer> list) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        if (!graph.containsKey(vertex)) {
            list.add(vertex);
            visited[vertex] = true;
            return true;
        }

        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, visiting, visited, neighbor, list)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        list.add(vertex);
        return true;
    }
}