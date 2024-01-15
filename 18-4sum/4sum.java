class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 3; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) continue;

            for (int k = l + 1; k < nums.length - 2; k++) {
                if (k > l + 1 && nums[k] == nums[k - 1]) continue;

                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[l], nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i + 1]) i++;
                        while (i < j && nums[j] == nums[j - 1]) j--;
                        i++;
                        j--;
                    } else if (sum < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return result;
    }
}