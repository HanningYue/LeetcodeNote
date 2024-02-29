class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, result, list, 0);
        return result;
    }
    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> list
    , int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }
}