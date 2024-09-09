class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, nums, 0, list);
        return result;
    }
    private void backTrack(List<List<Integer>> result, int[] nums, int index, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(result, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}