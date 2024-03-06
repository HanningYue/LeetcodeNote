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
        return dfs(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }
    private Node dfs(int[][] grid, int topRow, int colLeft, int bottomRow, int colRight) {
        if (topRow > bottomRow || colLeft > colRight) {
            return null;
        }

        int value = grid[topRow][colLeft];
        boolean same = true;
        for (int i = topRow; i <= bottomRow; i++) {
            for (int j = colLeft; j <= colRight; j++) {
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
        int midCol = (colLeft + colRight) / 2;
        current.isLeaf = false;
        current.topLeft = dfs(grid, topRow, colLeft, midRow, midCol);
        current.topRight = dfs(grid, topRow, midCol + 1, midRow, colRight);
        current.bottomLeft = dfs(grid, midRow + 1, colLeft, bottomRow, midCol);
        current.bottomRight = dfs(grid, midRow + 1, midCol + 1, bottomRow, colRight);
        return current;
    }
}
// topRow, colLeft,                            topRow, midCol + 1,             
//                     midRow, midCol,                         midRow, colRight

// midRow + 1, colLeft,                        midRow + 1, midCol + 1,
//                     bottomRow, midCol,                      bottomRow, colRight