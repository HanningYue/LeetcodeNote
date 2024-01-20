class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int suppose = nums[i] - 1;
            if (nums[suppose] != nums[i]) {
                int temp = nums[suppose];
                nums[suppose] = nums[i];
                nums[i] = temp;
            }
            else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(nums[j]);
            }
        }
        return result;
    }
}