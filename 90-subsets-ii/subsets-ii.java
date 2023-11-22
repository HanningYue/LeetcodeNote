/**
When we dealing with duplicate subsets, we need to sort the arrays first, because without sorting, the same number could be scattered across different parts of the array. The HashSet would then only be effective within a single recursion level, but not across multiple levels, leading to potential duplicate subsets in the result.
          a   a  b   c

              " "                    --   size 0
        /         \           \
      a          a           c      -- size 1
    /    \       /   \          /   \
  ac         ac           ca   cb 
  /             /
abc       abc
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(nums, result, list, 0);
        return result;
    }
    private void backTracking(int[] nums, List<List<Integer>> result, List<Integer> list, int level) {
        Set<Integer> set = new HashSet<>();
        result.add(new ArrayList<>(list));
        for (int i = level; i < nums.length; i++) {
            if (set.add(nums[i])) {
                list.add(nums[i]);
                backTracking(nums, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
