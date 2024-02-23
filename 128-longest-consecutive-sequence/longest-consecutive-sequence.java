class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentLength = 1;
                while (set.contains(num + 1)) {
                    num++;
                    currentLength++;
                }
                result = Math.max(result, currentLength);
            }
        }
        return result;
    }
}