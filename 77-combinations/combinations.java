class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(n, k, 1, result, list);
        return result;
    }
    private void backTrack(int n, int k, int index, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            backTrack(n, k, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}