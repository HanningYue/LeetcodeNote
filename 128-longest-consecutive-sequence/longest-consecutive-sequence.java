class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int localLength = 1;
                while (set.contains(num + 1)) {
                    localLength++;
                    num = num + 1;
                }
                maxLength = Math.max(maxLength, localLength);
            }
        }
        return maxLength;
    }
}