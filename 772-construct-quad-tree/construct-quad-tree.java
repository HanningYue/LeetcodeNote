/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length - 1, grid.length - 1);
    }
    private Node dfs(int[][] grid, int topRow, int leftCol, int bottomRow, int rightCol) {
        if (topRow > bottomRow || leftCol > rightCol) {
            return null;
        }

        int value = grid[topRow][leftCol];
        boolean same = true;
        for (int i = topRow; i <= bottomRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }
        }

        Node current = new Node();
        if (same) {
            current.isLeaf = true;
            current.val = value == 1;
            return current;
        }
        int midRow = (topRow + bottomRow) / 2;
        int midCol = (leftCol + rightCol) / 2;
        current.topLeft = dfs(grid, topRow, leftCol, midRow, midCol);
        current.topRight = dfs(grid, topRow, midCol + 1, midRow, rightCol);
        current.bottomLeft = dfs(grid, midRow + 1, leftCol, bottomRow, midCol);
        current.bottomRight = dfs(grid, midRow + 1, midCol + 1, bottomRow, rightCol);
        return current;
    }
}
/**
topRow, leftCol                 topRow, midCol + 1
        midRow, midCol                  midRow, rightCol
midRow + 1, leftCol             midRow + 1, midCol
        bottomRow, midCol               bottomRow, rightCol               
*/