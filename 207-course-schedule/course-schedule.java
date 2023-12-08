/**
Directional Graph, build graph first, then check for cycle, if no cycle, return true. Otherwise, false
Since directional, build single directional graph
无向图可以当作双向图来build
*/
class Solution {
    boolean[] visited, onPath;
    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !cycle;
    }
    private void traverse(List<Integer>[] graph, int vertex) {
        if (onPath[vertex]) {
            cycle = true;
        }
        if (cycle || visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        onPath[vertex] = true;
        for (int neighbor : graph[vertex]) {
            traverse(graph, neighbor);
        }
        onPath[vertex] = false;
    }
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }
        return graph;
    } 
}