class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(result, 0, target, list, candidates);
        return result;
    }
    private void backTracking(List<List<Integer>> result, int current, int target, 
    List<Integer> list, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
        }
        for (int i = current; i < candidates.length; i++) {
            if (i > current && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTracking(result, i + 1, target - candidates[i], list, candidates);
            list.remove(list.size() - 1);
        }
    }
}