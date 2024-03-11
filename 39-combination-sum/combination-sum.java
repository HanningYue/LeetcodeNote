class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, target, result, list, 0);
        return result;
    }
    private void backTrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, 
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
            backTrack(candidates, target - candidates[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }
}