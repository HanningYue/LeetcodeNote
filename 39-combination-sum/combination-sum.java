class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, target, 0, 0, result, list);
        return result;
    }
    private void backTrack(int[] nums, int target, int runningSum, int index, 
    List<List<Integer>> result, List<Integer> list) {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, target, runningSum + nums[i], i, result, list);
            list.remove(list.size() - 1);
        }
    }
}