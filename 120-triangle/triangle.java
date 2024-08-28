class Solution {
    Integer[][] dpTable;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(triangle.size() - 1).size();
        dpTable = new Integer[m][n];
        return dp(triangle, 0, 0);
    }

    private int dp(List<List<Integer>> triangle, int currentRow, int currentCol) {
        if (currentRow == triangle.size()) {
            return 0;
        }
        if (dpTable[currentRow][currentCol] != null) {
            return dpTable[currentRow][currentCol];
        }

        int goDown = dp(triangle, currentRow + 1, currentCol);
        int goDownRight = dp(triangle, currentRow + 1, currentCol + 1);
        
        dpTable[currentRow][currentCol] 
        = Math.min(goDown, goDownRight) + triangle.get(currentRow).get(currentCol);
        
        return dpTable[currentRow][currentCol];
    }
}