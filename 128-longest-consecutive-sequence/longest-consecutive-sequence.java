class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int localLength = 1;
                while (set.contains(num + 1)) {
                    localLength++;
                    num++;
                }
                maxLength = Math.max(maxLength, localLength);
            }
        }
        return maxLength;
    }
}