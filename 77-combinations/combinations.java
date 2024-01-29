class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(n, k, result, list, 1);
        return result;
    }
    private void backTrack(int n, int k, List<List<Integer>> result, List<Integer> list, int index) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            backTrack(n, k, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}