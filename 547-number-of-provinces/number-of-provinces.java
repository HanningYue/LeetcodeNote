class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int n = isConnected.length;
        int count = 0;

        for (int city = 0; city < n; city++) {
            if (!visited.contains(city)) {
                count++;
                dfs(city, visited, isConnected);
            }
        }
        return count;
    }
    private void dfs(int city, Set<Integer> visited, int[][] isConnected) {
        if (visited.contains(city)) {
            return;
        }
        visited.add(city);
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1) {
                dfs(i, visited, isConnected);
            }
        }
    }
}