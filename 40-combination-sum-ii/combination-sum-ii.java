/**
Based on the Combination Sum I, we only need to change i to i + 1, because we only allowed to use the current startIndex number once
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, result, list, 0);
        return result;
    }
    private void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> list, int startIndex) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            
            list.add(nums[i]);
            backtrack(nums, target - nums[i], result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}