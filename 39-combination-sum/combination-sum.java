class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, 0, target, result, list);
        return result;
    }
    private void backTrack(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTrack(candidates, i, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
    }
}