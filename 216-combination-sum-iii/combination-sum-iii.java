class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(k, n, result, list, 1, 0);
        return result;
    }
    private void backTrack(int k, int n, List<List<Integer>> result, List<Integer> list, int index, int runningSum) {
        if (list.size() == k && runningSum == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > n) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            runningSum += i;
            backTrack(k, n, result, list, i + 1, runningSum);
            runningSum -= i;
            list.remove(list.size() - 1);
        }
    }
}