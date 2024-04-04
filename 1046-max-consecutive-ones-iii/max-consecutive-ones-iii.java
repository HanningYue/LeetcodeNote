class Solution {
    public int longestOnes(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, maxOnes = 0;

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            int fastNum = nums[fast];
            map.put(fastNum, map.getOrDefault(fastNum, 0) + 1);
            if (fastNum == 1) {
                maxOnes = Math.max(maxOnes, map.get(fastNum));
            }

            while (fast - slow + 1 - maxOnes > k) {
                int slowNum = nums[slow];
                map.put(slowNum, map.get(slowNum) - 1);
                slow++;
            }
            
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}