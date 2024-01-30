class Solution {
    int[][] table;
    public int numTrees(int n) {
        table = new int[n + 1][n + 1];
        return count(1, n);
    }
    private int count(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (table[start][end] != 0) {
            return table[start][end];
        }

        int result = 0;
        for (int mid = start; mid <= end; mid++) {
            int left = count(start, mid - 1);
            int right = count(mid + 1, end);
            result += left * right;
        }

        table[start][end] = result;
        return result;
    }
}