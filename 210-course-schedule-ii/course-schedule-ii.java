class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            graph.get(to).add(from);
        }

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited, visiting, list)) {
                return new int[]{};
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, int vertex, boolean[] visited, 
                    boolean[] visiting, List<Integer> list) {
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
            if (!dfs(graph, neighbor, visited, visiting, list)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        list.add(vertex);
        return true;
    }
}