/**
Directional Graph, build graph first, then check for cycle, if no cycle, return true. Otherwise, false
Since directional, build single directional graph
无向图可以当作双向图来build
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            int to = pre[0];
            int from = pre[1];
            graph[from].add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!traverse(i, visiting, visited, graph)) {
                return false;
            }
        }
        return true;
    }
    private boolean traverse(int vertex, boolean[] visiting, boolean[] visited,
    List<Integer>[] graph) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!traverse(neighbor, visiting, visited, graph)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}