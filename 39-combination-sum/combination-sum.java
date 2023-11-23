/**
1. Since we can use the same number unlimited times, we do not need to check duplicate or start the next recursion on the next startIndex
2. ATTENTION : need to check the case when target is less than 0
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(candidates, target, result, list, 0);
        return result;
    }
    private void backTracking(int[] candidates, int target, List<List<Integer>> result,
    List<Integer> list, int startIndex)
    {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList(list));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTracking(candidates, target - candidates[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }
}