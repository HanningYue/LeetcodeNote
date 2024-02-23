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
                uf.union(map.get(nums[i] + 1), i);
            }
            if (map.containsKey(nums[i] - 1)) {
                uf.union(map.get(nums[i] - 1), i);
            }
        }
        return uf.maxUnionGroup();
    }
}
class UF {
    private int count;
    private int[] parents;
    public UF(int num) {
        this.count = num;
        parents = new int[num];
        for (int i = 0; i < num; i++) {
            parents[i] = i;
        }
    }
    public void union(int one, int two) {
        if (find(one) != find(two)) {
            parents[find(one)] = find(two);
            count--;
        }
        return;
    }
    public boolean connected(int one, int two) {
        return find(one) == find(two);
    }
    public int find(int vertex) {
        if (parents[vertex] != vertex) {
            parents[vertex] = find(parents[vertex]);
        }
        return parents[vertex];
    }
    public int count() {
        return count;
    }
    public int maxUnionGroup() {
        int[] arrForIdxAsParent = new int[parents.length];
        int max = 0;
        for (int i = 0; i < parents.length; i++) {
            arrForIdxAsParent[find(i)]++;
            max = Math.max(max, arrForIdxAsParent[find(i)]);
        }
        return max;
    }
}