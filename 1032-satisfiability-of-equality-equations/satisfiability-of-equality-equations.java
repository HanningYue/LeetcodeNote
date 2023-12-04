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
class UF{
    int count;
    int[] parent;
    public UF (int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public int count() {
        return count;
    }
}