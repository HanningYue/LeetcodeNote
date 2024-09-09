class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, candidates, target, 0, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, 
    int runningSum, int index) {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            runningSum += candidates[i];
            list.add(candidates[i]);
            backTrack(result, list, candidates, target, runningSum, i);
            runningSum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}