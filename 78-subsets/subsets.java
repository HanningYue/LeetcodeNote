class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, nums, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {    
        result.add(new ArrayList<>(list));
        
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}