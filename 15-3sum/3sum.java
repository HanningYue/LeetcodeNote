class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 2; k < nums.length; k++) {
            if (k + 1 < nums.length && nums[k + 1] == nums[k]) {
                continue;
            }
            int i = 0, j = k - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i + 1 < j && nums[i + 1] == nums[i]) {
                        i++;
                    }
                    i++;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }
}