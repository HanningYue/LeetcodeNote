class Solution {
    int[][] dpTable;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dpTable = new int[n][n];
        for (int[] row : dpTable) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dpTable[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j < currentRow.size(); j++) {
                if (j - 1 < 0) {
                    dpTable[i][j] = dpTable[i - 1][j] + currentRow.get(j);
                }
                else if (j - 1 >= 0) {
                    dpTable[i][j] 
                    = Math.min(dpTable[i - 1][j], dpTable[i - 1][j - 1]) + currentRow.get(j);
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < dpTable[n - 1].length; i++) {
            result = Math.min(result, dpTable[n - 1][i]);
        }
        return result;
    }
}