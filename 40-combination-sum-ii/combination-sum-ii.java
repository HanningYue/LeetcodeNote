class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, candidates, target, 0, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index, 
    int runningSum) {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            runningSum += candidates[i];
            list.add(candidates[i]);
            backTrack(result, list, candidates, target, i + 1, runningSum);
            runningSum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}