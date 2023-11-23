/*
每次要加入新的object，对于当前level，backtracking时加入 startIndex + 1，因为想要所有的组合
    [0 element] [1 element] [2 elements] [3 elements]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(nums, result, list, 0);
        return result;
    }
    private void backTracking(int[] nums, List<List<Integer>> result, List<Integer> list, int startIndex) {
        result.add(new ArrayList<>(list));

        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
