/**
Iterate whole nums array despite the level number, we dont need startIndex since the result always have 
nums.length as size
Use a boolean[] to mark the visited number
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums, result, list, used);
        return result;
    }
    private void backTracking(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                backTracking(nums, result, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}