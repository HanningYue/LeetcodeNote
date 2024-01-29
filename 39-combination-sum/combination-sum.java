class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, nums, target, 0, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, 
    int target, int level, int runningSum) 
    {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            runningSum += nums[i];
            backTrack(result, list, nums, target, i, runningSum);
            list.remove(list.size() - 1);
            runningSum -= nums[i];
        }
    }
}