class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int pairs = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pairs--;
            } else if (nums[i] == 1) {
                pairs++;
            }

            if (map.containsKey(pairs)) {
                maxLength = Math.max(maxLength, i - map.get(pairs));
            } else {
                map.put(pairs, i);
            }
        }
        return maxLength;
    }
}