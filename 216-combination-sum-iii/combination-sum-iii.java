class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, k, n, 1, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int k, int n, int level, int sum) {
        if (list.size() == k && sum == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i = level; i <= 9; i++) {
            sum += i;
            list.add(i);
            backTrack(result, list, k, n, i + 1, sum);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }
}