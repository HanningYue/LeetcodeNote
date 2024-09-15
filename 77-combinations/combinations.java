class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(n, k, list, result, 1);
        return result;
    }
    private void backTrack(int n, int k, List<Integer> list, List<List<Integer>> result, int index) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backTrack(n, k, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}