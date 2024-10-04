class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, -1);
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            }
            map.putIfAbsent(count, i);

        }
        return maxLength;
    }
}