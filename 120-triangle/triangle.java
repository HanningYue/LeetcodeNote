import java.util.List;

class Solution {
    Integer[][] dpTable;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dpTable = new Integer[n][n]; // Use Integer for null check
        return dp(triangle, 0, 0);
    }

    private int dp(List<List<Integer>> triangle, int row, int col) {
        // Base case: if we reach beyond the last row, no more steps required
        if (row == triangle.size()) {
            return 0;
        }
        // Check if the result is already computed
        if (dpTable[row][col] != null) {
            return dpTable[row][col];
        }
        // Recursive case: choose the minimum path sum of the current position by deciding to go down or diagonally right down
        int down = dp(triangle, row + 1, col);
        int diagRight = dp(triangle, row + 1, col + 1);
        // Calculate the minimum path sum for the current position
        dpTable[row][col] = Math.min(down, diagRight) + triangle.get(row).get(col);
        return dpTable[row][col];
    }
}
