/**
When we dealing with duplicate subsets, we need to sort the arrays first, because without sorting, the same number could be scattered across different parts of the array. Then manipulate array index, comparing nums[i]
with nums[i - 1], if they are the same, skip the current iteration
          a   a  b   c

              " "                    --   size 0, level 0
        /         \           \
      a          a           c      -- size 1, level 1
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
        backTracking(nums, 0, result, list);
        return result;
    }

    private void backTracking(int[] nums, int level, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for(int i = level; i < nums.length; i++){
            if(i > level && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            backTracking(nums, i + 1, result, list);
            list.remove(list.size()-1);
        }
    }
}
