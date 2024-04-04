class Solution {
    public int longestOnes(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //{num, freq}
        int maxOne = 0, result = 0;

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            int current = nums[fast];
            map.put(current, map.getOrDefault(current, 0) + 1);
            if (current == 1) {
                maxOne = Math.max(maxOne, map.get(current));
            }

            while (fast - slow + 1 - maxOne > k) {
                int slowCurrent = nums[slow];
                map.put(slowCurrent, map.get(slowCurrent) - 1);
                slow++;
            }
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}