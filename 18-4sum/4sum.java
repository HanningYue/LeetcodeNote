import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        long longTarget = (long) target;
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, longTarget);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || size < n) return result;

        if (n == 2) {
            int low = start, high = size - 1;
            while (low < high) {
                long sum = (long) nums[low] + (long) nums[high];
                int left = nums[low], right = nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left) low++;
                } else if (sum > target) {
                    while (low < high && nums[high] == right) high--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (low < high && nums[low] == left) low++;
                    while (low < high && nums[high] == right) high--;
                }
            }
        } else {
            for (int i = start; i < size; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    result.add(arr);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return result;
    }
}
