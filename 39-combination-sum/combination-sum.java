class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, target, 0, candidates, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int target, int runningSum, 
    int[] candidates, int index) {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            runningSum += candidates[i];
            backTrack(result, list, target, runningSum, candidates, i);
            runningSum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}