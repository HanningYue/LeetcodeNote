/*
In Binary Search, the low and high are usually index-boundary, not value boundary
In this proble, we starts at TOP-RIGHT, let row = 0 and column = matrix[0].length - 1
    Condition is while row in matrix.length boundary and column >= 0
    For each value, START at top-right
        if smaller than target -> increase row number
        if bigger than target -> decrease column number
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        
        while (row < matrix.length && column >= 0) {
            int currentNumber = matrix[row][column];
            if (currentNumber > target) {
                column--;
            } else if (currentNumber < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}