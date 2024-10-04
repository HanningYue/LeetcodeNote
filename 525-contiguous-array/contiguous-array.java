class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == 0 ? -1 : 1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < prefix.length; i++) {
            if (!map.containsKey(prefix[i])) {
                map.put(prefix[i], i);
            } else {
                maxLength = Math.max(maxLength, i - map.get(prefix[i]));
            }
        }

        return maxLength;
    }
}