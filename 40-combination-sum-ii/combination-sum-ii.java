class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, result, list, target, 0);
        return result;
    }
    private void backTrack(int[] candidates, List<List<Integer>> result, List<Integer> list, int target,
    int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrack(candidates, result, list, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}