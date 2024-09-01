class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (k - 1 >= 0 && nums[k - 1] == nums[k]) {
                continue;
            }

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i + 1 < j && nums[i + 1] == nums[i]) {
                        i++;
                    }
                    i++;
                    while (i + 1 < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    j--;
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