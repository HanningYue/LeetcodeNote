class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, 0, nums);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int level, int[] nums) {
        result.add(new ArrayList<>(list));
        
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(result, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
