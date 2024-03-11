class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, candidates, target, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, 
                           int level) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTrack(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}