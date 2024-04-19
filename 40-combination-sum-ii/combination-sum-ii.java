class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, result, list, target, 0, 0);
        return result;
    }
    private void backTrack(int[] candidates, List<List<Integer>> result, List<Integer> list, int target,
                           int runningSum, int index)
    {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrack(candidates, result, list, target, runningSum + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}