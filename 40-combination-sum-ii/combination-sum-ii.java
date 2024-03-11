class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, candidates, 0, target, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int sum, 
                           int target, int level) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            if (i > level && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrack(result, list, candidates, sum + candidates[i], target, i + 1);
            list.remove(list.size() - 1);
        }
    }
}