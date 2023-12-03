/**
DFS2, need to detect cycle in the graph
VISITING VS. VISITED
1. Dfs2,  we need to detect cycle in the given questions 构图
2. Given an int[][], we need to convert it to a HashMap first, {course, Set(all its prerequisites)}
3. When dfs traversing, return a boolean value to keep track of the current state of cycle detection, if there is a cycle, return false
*/
class Solution {
    boolean[] onPath;
    boolean[] visited;
    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !cycle;
    }
    private void traverse(List<Integer>[] graph, int vertex) {
        if (onPath[vertex]) {
            cycle = true;
        }
        if (visited[vertex] || cycle) {
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
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}