/**
        1   1   2   6   5   7   10
    12657 10265710
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, target, result, list, 0, 0);
        return result;
    }
    private void backTrack(int[] nums, int target, List<List<Integer>> result, List<Integer> list, 
    int runningSum, int index) {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, target, result, list, runningSum + nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}