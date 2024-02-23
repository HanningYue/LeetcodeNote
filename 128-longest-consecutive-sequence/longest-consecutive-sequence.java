class Solution {
    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
        }
        return uf.maxUnion();
    }
}
class UF {
    private int[] parents;
    private int count;
    public UF(int n) {
        parents = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    public int find(int vertexOne) {
        if (parents[vertexOne] != vertexOne) {
            parents[vertexOne] = find(parents[vertexOne]);
        }
        return parents[vertexOne];

    }
    public void union(int one, int two) {
        if (find(one) != find(two)) {
            parents[find(one)] = parents[find(two)];
            count--;
        }
        return;
    }
    public boolean connected(int one, int two) {
        return find(one) == find(two);
    }
    public int count() {
        return count;
    }
    public int maxUnion() {
        int[] result = new int[parents.length];
        int max = 0;
        for (int i = 0; i < parents.length; i++) {
            result[find(i)]++;
            max = Math.max(max, result[find(i)]);
        }
        return max;
    }
}