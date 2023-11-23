/**
Based on the Combination Sum I, we only need to change i to i + 1, because we only allowed to use the current startIndex number once
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(candidates, target, 0, result, list);
        return result;
    }
    private void backTracking(int[] candidates, int target, int startIndex, 
    List<List<Integer>> result, List<Integer> list)
    {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}