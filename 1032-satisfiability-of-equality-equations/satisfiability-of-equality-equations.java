class UF {
    private int count;
    private int[] parent;
    public UF(int numberOfVertex) {
        this.count = numberOfVertex;
        parent = new int[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            parent[i] = i;
        }
    }
    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }
    public void union(int vertexOne, int vertexTwo) {
        int parentOne = find(vertexOne);
        int parentTwo = find(vertexTwo);
        if (parentOne != parentTwo) {
            parent[parentOne] = parentTwo;
            count--;
        }
    }
    public boolean connected(int vertexOne, int vertexTwo) {
        return find(vertexOne) == find(vertexTwo);
    }
    public int count() {
        return count;
    }
}
class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}