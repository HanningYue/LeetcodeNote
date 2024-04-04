class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int localLength = 1;
                while (set.contains(num + 1)) {
                    num++;
                    localLength++;
                }
                maxLength = Math.max(maxLength, localLength);
            }
        }
        return maxLength;
    }
}