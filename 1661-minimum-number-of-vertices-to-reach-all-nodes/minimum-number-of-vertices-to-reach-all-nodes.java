class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] sourceNode = new int[n];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            sourceNode[to]++;
        }
        for (int i = 0; i < sourceNode.length; i++) {
            if (sourceNode[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}