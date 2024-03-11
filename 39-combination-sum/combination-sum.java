class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, candidates, target, 0, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, 
                           int level, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            backTrack(result, list, candidates, target, i, sum);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
/**
             []
        /     |      \
    []        []      []
/   |  \     / \       |
[]  []  []  [] []      []
*/