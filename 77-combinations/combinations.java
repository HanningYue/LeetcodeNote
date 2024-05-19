class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, 1, k, n);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int index, int k, int n) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backTrack(result, list, i + 1, k, n);
            list.remove(list.size() - 1);
        }
    }
}