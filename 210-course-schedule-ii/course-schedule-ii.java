class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(to).add(from);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visiting, visited, list)) {
                return new int[]{};
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private boolean dfs(int vertex, Map<Integer, List<Integer>> graph, boolean[] visiting,
    boolean[] visited, List<Integer> list) {
        if (visited[vertex]) {
            return true;
        }
        if (!graph.containsKey(vertex)) {
            list.add(vertex);
            visited[vertex] = true;
            return true;
        }
        if (visiting[vertex]) {
            return false;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(neighbor, graph, visiting, visited, list)) {
                return false;
            }
        }
        list.add(vertex);
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}