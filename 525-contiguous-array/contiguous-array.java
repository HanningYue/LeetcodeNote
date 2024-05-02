class Solution {
    public int findMaxLength(int[] nums) {
        int pair = 0, maxLength = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pair++;
            } else if (nums[i] == 0) {
                pair--;
            }

            if (map.containsKey(pair)) {
                maxLength = Math.max(maxLength, i - map.get(pair));
            } else {
                map.put(pair, i);
            }
        }
        return maxLength;
    }
}