class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.get(from).add(to);
        }

        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visiting, visited, i, list)) {
                return new int[]{};
            }
        }
        
        Collections.reverse(list);
        int[] result = new int[numCourses];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visiting, 
    boolean[] visited, int vertex, List<Integer> list) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, visiting, visited, neighbor, list)) {
                return false;
            }
        }
        list.add(vertex);
        visiting[vertex] = false;
        return true;
    }
}