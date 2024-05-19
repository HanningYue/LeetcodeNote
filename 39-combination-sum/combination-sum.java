class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, 0, 0, candidates, target);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int runningSum, 
                           int index, int[] nums, int target)
    {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            runningSum += nums[i];
            list.add(nums[i]);
            backTrack(result, list, runningSum, i, nums, target);
            runningSum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
                           
}