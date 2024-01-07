class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] source = new int[n];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            source[to]++;
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}