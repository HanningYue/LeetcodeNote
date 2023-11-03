class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{i, map.get(remain)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = copy[left] + copy[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == copy[left]) result[0] = i;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == copy[right]) result[1] = i;
        }
        return result;
    }
}
*/