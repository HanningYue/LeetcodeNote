/**

*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(result, list, used, nums);
        return result;
    }
    private void backTracking(List<List<Integer>> result, List<Integer> list, boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                backTracking(result, list, used, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}