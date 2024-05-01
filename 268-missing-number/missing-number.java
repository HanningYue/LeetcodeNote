class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (num != 0 && !set.contains(num - 1)) {
                return num - 1;
            }
        }
        return nums.length;
    }
}