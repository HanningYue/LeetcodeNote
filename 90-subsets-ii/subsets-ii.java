/**
When we dealing with duplicate subsets, we need to sort the arrays first, because without sorting, the same number could be scattered across different parts of the array. Then manipulate array index, comparing nums[i]
with nums[i - 1], if they are the same, skip the current iteration
          a   a  b   c

              " "                    --   size 0, startIndex 0
        /         \           \
      a          a           c      -- size 1, startIndex 1
    /    \       /   \          /   \
  ac         ac           ca   cb 
  /             /
abc       abc
    i represents the current index in the array being processed.
    startIndex represents the starting index for the current recursive call.
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(nums, 0, result, list);
        return result;
    }
    private void backTracking(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backTracking(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}