/**
DFS2, need to detect cycle in the graph
VISITING VS. VISITED
1. Dfs2,  we need to detect cycle in the given questions 构图
2. Given an int[][], we need to convert it to a HashMap first, {course, Set(all its prerequisites)}
3. When dfs traversing, return a boolean value to keep track of the current state of cycle detection, if there is a cycle, return false
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        
        Map<Integer, Set<Integer>> map = new HashMap<>(); //Map Init
        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new HashSet<>());
            map.get(pre[0]).add(pre[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(visiting, visited, course, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[] visiting, boolean[] visited, int course, Map<Integer, Set<Integer>> map) {
        if (!map.containsKey(course) || visited[course]) {
            return true;
        }
        if (visiting[course]) {
            return false;
        }
        visiting[course] = true;
        for (int neighbor : map.get(course)) {
            if (!dfs(visiting, visited, neighbor, map)) {
                return false;
            }
        }
        visiting[course] = false;
        visited[course] = true;
        return true;
    }
}